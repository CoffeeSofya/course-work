package com.course.work.cdrent.listgenre.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class ListGenreDto {

    @NotNull
//    @Size(max = 10)
    private Integer numGenre;
    @NotNull
    @Size(max = 30)
    private String genre;
}
