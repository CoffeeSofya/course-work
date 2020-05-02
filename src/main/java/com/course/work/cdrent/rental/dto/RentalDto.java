package com.course.work.cdrent.rental.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class RentalDto {
    @NotNull
    private Integer numRental;
    private Integer numCd;
    private Integer numRenter;
    private Date dateRental;
}
