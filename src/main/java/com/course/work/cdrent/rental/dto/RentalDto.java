package com.course.work.cdrent.rental.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class RentalDto {
    @NotNull
//    @Size(max = 6)
    private Integer numRental;
    @NotNull
//    @Size(max = 6)
    private Integer numCd;
    @NotNull
//    @Size(max = 6)
    private Integer numRenter;
    @NotNull

//    @Size(max = 10)
//    @NotBlank(message = "введите дату в формате yyyy-mm-dd")
    @Past
    private Date dateRental;
}
