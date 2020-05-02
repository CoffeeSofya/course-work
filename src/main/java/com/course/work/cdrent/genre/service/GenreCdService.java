package com.course.work.cdrent.genre.service;

import com.course.work.cdrent.genre.dto.GenreCdDto;
import com.course.work.cdrent.genre.entity.GenreCdEntity;
import com.course.work.cdrent.genre.mapper.GenreCdMapper;
import com.course.work.cdrent.genre.repository.GenreCdRepository;
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
public class GenreCdService {
    private final GenreCdRepository repository;
    private final GenreCdMapper mapper;

    public List<GenreCdDto> getAllGenreCd() {
        return repository.findAll().stream().map(mapper::map).collect(Collectors.toList())
                .stream()
                .sorted(Comparator.comparingInt(GenreCdDto::getId))
                .collect(Collectors.toList());
    }

    public GenreCdDto getById(Integer id) {
        log.info("Пришел запрос на получение GenreCd с id = {}",id);
        Optional<GenreCdEntity> optional = repository.findById(id);
        if (!optional.isPresent()) {
            throw new RuntimeException("Такого GenreCd не существует");
        }
        return mapper.map(optional.get());
    }

    public void save(GenreCdDto dto) {
        log.info("Пришел запрос на сохранение GenreCd с id = {}", dto.getId());
        Optional<GenreCdEntity> optional = repository.findById(dto.getId());
        if (optional.isPresent()) {
            log.info("У нас уже есть такая запись, производим обновление данных");
            GenreCdEntity entity = optional.get();
            mapper.fill(entity,dto);
            repository.save(entity);
            return;
        }
        log.info("Такой записи у нах нет, производим создание данных");
        repository.save(mapper.map(dto));
    }

    public void delete(Integer id) {
        log.info("Пришел запрос на удаление GenreCd с id = {}", id);
        repository.deleteById(id);
    }
}
