package com.course.work.cdrent.listgenre.service;

import com.course.work.cdrent.listgenre.dto.ListGenreDto;
import com.course.work.cdrent.listgenre.entity.ListGenreEntity;
import com.course.work.cdrent.listgenre.mapper.ListGenreMapper;
import com.course.work.cdrent.listgenre.repository.ListGenreRepository;
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
public class ListGenreService {
    private final ListGenreRepository repository;
    private final ListGenreMapper mapper;

    public List<ListGenreDto> getAllListGenre() {
        return repository.findAll().stream().map(mapper::map).collect(Collectors.toList())
                .stream()
                .sorted(Comparator.comparingInt(ListGenreDto::getNumGenre))
                .collect(Collectors.toList());
    }

    public ListGenreDto getById(Integer id) {
        log.info("Пришел запрос на получение ListGenre с id = {}",id);
        Optional<ListGenreEntity> optional = repository.findById(id);
        if (!optional.isPresent()) {
            throw new RuntimeException("Такого ListGenre не существует");
        }
        return mapper.map(optional.get());
    }

    public void save(ListGenreDto dto) {
        log.info("Пришел запрос на сохранение ListGenre с id = {}", dto.getNumGenre());
        Optional<ListGenreEntity> optional = repository.findById(dto.getNumGenre());
        if (optional.isPresent()) {
            log.info("У нас уже есть такая запись, производим обновление данных");
            ListGenreEntity entity = optional.get();
            mapper.fill(entity,dto);
            repository.save(entity);
            return;
        }
        log.info("Такой записи у нах нет, производим создание данных");
        repository.save(mapper.map(dto));
    }

    public void delete(Integer id) {
        log.info("Пришел запрос на удаление ListGenre с id = {}", id);
        repository.deleteById(id);
    }

    public List<ListGenreDto> getGenresForCd(Integer numCd) {
        return repository.getGenresForNumCd(numCd).stream()
                .map(e -> new ListGenreDto(e.getNumGenre(),e.getGenre()))
                .collect(Collectors.toList());
    }
}
