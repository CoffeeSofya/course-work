package com.course.work.cdrent.renter.service;

import com.course.work.cdrent.renter.dto.RenterDto;
import com.course.work.cdrent.renter.entity.RenterEntity;
import com.course.work.cdrent.renter.mapper.RenterMapper;
import com.course.work.cdrent.renter.repository.RenterRepository;
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
public class RenterService {
    private final RenterRepository repository;
    private final RenterMapper mapper;

    public List<RenterDto> getAllRenter() {
        return repository.findAll().stream().map(mapper::map).collect(Collectors.toList())
                .stream()
                .sorted(Comparator.comparingInt(RenterDto::getNumRenter))
                .collect(Collectors.toList());
    }

    public RenterDto getById(Integer id) {
        log.info("Пришел запрос на получение Renter с id = {}",id);
        Optional<RenterEntity> optional = repository.findById(id);
        if (!optional.isPresent()) {
            throw new RuntimeException("Такого Renter не существует");
        }
        return mapper.map(optional.get());
    }

    public void save(RenterDto dto) {
        log.info("Пришел запрос на сохранение Renter с id = {}", dto.getNumRenter());
        Optional<RenterEntity> optional = repository.findById(dto.getNumRenter());
        if (optional.isPresent()) {
            log.info("У нас уже есть такая запись, производим обновление данных");
            RenterEntity entity = optional.get();
            mapper.fill(entity,dto);
            repository.save(entity);
            return;
        }
        log.info("Такой записи у нах нет, производим создание данных");
        repository.save(mapper.map(dto));
    }

    public void delete(Integer id) {
        log.info("Пришел запрос на удаление Renter с id = {}", id);
        repository.deleteById(id);
    }
}
