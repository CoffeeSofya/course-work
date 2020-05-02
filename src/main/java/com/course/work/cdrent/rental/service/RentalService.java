package com.course.work.cdrent.rental.service;

import com.course.work.cdrent.rental.dto.RentalDto;
import com.course.work.cdrent.rental.entity.RentalEntity;
import com.course.work.cdrent.rental.mapper.RentalMapper;
import com.course.work.cdrent.rental.repository.RentalRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class RentalService {
    private final RentalRepository repository;
    private final RentalMapper mapper;

    public List<RentalDto> getAllRental() {
        return repository.findAll().stream().map(mapper::map).collect(Collectors.toList())
                .stream()
                .sorted(Comparator.comparingInt(RentalDto::getNumRental))
                .collect(Collectors.toList());
    }

    public RentalDto getById(Integer id) {
        log.info("Пришел запрос на получение Rental с id = {}",id);
        Optional<RentalEntity> optional = repository.findById(id);
        if (!optional.isPresent()) {
            throw new RuntimeException("Такого Rental не существует");
        }
        return mapper.map(optional.get());
    }

    public void save(RentalDto dto) {
        log.info("Пришел запрос на сохранение Rental с id = {}", dto.getNumRental());
        Optional<RentalEntity> optional = repository.findById(dto.getNumRental());
        if (optional.isPresent()) {
            log.info("У нас уже есть такая запись, производим обновление данных");
            RentalEntity entity = optional.get();
            mapper.fill(entity,dto);
            repository.save(entity);
            return;
        }
        log.info("Такой записи у нах нет, производим создание данных");
        repository.save(mapper.map(dto));
    }

    public void delete(Integer id) {
        log.info("Пришел запрос на удаление Rental с id = {}", id);
        repository.deleteById(id);
    }
}
