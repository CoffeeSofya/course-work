package com.course.work.cdrent.listgenre.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class ListGenreDto {

    @NotNull
    private Integer numGenre;
    @NotNull
    private String genre;
}
