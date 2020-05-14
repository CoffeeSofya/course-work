package com.course.work.cdrent.genre.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class GenreCdDto {
    @NotNull
    @Positive
//    @Size(max = 10)
    private Integer id;
    @NotNull
    @Positive
//    @Size(max = 10)
    private Integer numCd;
    @NotNull
    @Positive
//    @Size(max = 10)
    private Integer numGenre;
}