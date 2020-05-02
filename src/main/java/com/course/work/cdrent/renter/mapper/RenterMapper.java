package com.course.work.cdrent.renter.mapper;

import com.course.work.cdrent.renter.dto.RenterDto;
import com.course.work.cdrent.renter.entity.RenterEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface RenterMapper {
    void fill(@MappingTarget RenterEntity entity, RenterDto dto);

    void fill(@MappingTarget RenterDto dto, RenterEntity entity);

    RenterDto map(RenterEntity entity);

    RenterEntity map(RenterDto dto);
}
