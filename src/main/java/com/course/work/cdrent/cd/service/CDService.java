package com.course.work.cdrent.cd.service;

import com.course.work.cdrent.cd.dto.CDDto;
import com.course.work.cdrent.cd.entity.CDEntity;
import com.course.work.cdrent.cd.mapper.CDMapper;
import com.course.work.cdrent.cd.repository.CDRepository;
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
public class CDService {
    private final CDRepository repository;
    private final CDMapper mapper;

    public List<CDDto> getAllCD() {
        return repository.findAll().stream().map(mapper::map).collect(Collectors.toList())
                .stream()
                .sorted(Comparator.comparingInt(CDDto::getNumCd))
                .collect(Collectors.toList());
    }

    public CDDto getById(Integer id) {
        log.info("Пришел запрос на получение CD с id = {}",id);
        Optional<CDEntity> optional = repository.findById(id);
        if (!optional.isPresent()) {
            throw new RuntimeException("Такого CD не существует");
        }
        return mapper.map(optional.get());
    }

    public void save(CDDto dto) {
        log.info("Пришел запрос на сохранение CD с id = {}", dto.getNumCd());
        Optional<CDEntity> optional = repository.findById(dto.getNumCd());
        if (optional.isPresent()) {
            log.info("У нас уже есть такая запись, производим обновление данных");
            CDEntity entity = optional.get();
            mapper.fill(entity,dto);
            repository.save(entity);
            return;
        }
        log.info("Такой записи у нах нет, производим создание данных");
        repository.save(mapper.map(dto));
    }

    public void delete(Integer id) {
        log.info("Пришел запрос на удаление CD с id = {}", id);
        repository.deleteById(id);
    }
}
