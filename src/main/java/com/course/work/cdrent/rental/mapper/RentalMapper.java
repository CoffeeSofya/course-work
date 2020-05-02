package com.course.work.cdrent.rental.mapper;

import com.course.work.cdrent.rental.dto.RentalDto;
import com.course.work.cdrent.rental.entity.RentalEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface RentalMapper {
    void fill(@MappingTarget RentalEntity entity, RentalDto dto);

    void fill(@MappingTarget RentalDto dto, RentalEntity entity);

    RentalDto map(RentalEntity entity);

    RentalEntity map(RentalDto dto);
}
