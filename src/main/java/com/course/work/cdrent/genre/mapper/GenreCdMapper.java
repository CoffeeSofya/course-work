package com.course.work.cdrent.genre.mapper;

import com.course.work.cdrent.genre.dto.GenreCdDto;
import com.course.work.cdrent.genre.entity.GenreCdEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface GenreCdMapper {
    void fill(@MappingTarget GenreCdEntity entity, GenreCdDto dto);

    void fill(@MappingTarget GenreCdDto dto, GenreCdEntity entity);

    GenreCdDto map(GenreCdEntity entity);

    GenreCdEntity map(GenreCdDto dto);
}
