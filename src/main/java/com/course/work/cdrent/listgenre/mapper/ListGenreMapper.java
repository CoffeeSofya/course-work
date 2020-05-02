package com.course.work.cdrent.listgenre.mapper;

import com.course.work.cdrent.listgenre.dto.ListGenreDto;
import com.course.work.cdrent.listgenre.entity.ListGenreEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ListGenreMapper {
    void fill(@MappingTarget ListGenreEntity entity, ListGenreDto dto);

    void fill(@MappingTarget ListGenreDto dto, ListGenreEntity entity);

    ListGenreDto map(ListGenreEntity entity);

    ListGenreEntity map(ListGenreDto dto);
}
