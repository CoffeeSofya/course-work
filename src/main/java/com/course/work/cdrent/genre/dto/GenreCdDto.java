package com.course.work.cdrent.genre.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class GenreCdDto {
    @NotNull
    private Integer id;
    @NotNull
    private Integer numCd;
    @NotNull
    private Integer numGenre;
}