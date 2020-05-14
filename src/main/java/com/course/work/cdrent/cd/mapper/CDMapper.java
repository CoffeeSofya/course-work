package com.course.work.cdrent.cd.mapper;

import com.course.work.cdrent.cd.dto.CDDto;
import com.course.work.cdrent.cd.entity.CDEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface CDMapper {
    void fill(@MappingTarget CDEntity entity, CDDto dto);

    void fill(@MappingTarget CDDto dto, CDEntity entity);

    CDDto map(CDEntity entity);

    CDEntity map(CDDto dto);

}
