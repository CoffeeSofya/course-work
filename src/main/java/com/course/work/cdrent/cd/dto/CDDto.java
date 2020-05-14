package com.course.work.cdrent.cd.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class CDDto {
    @NotNull
    @Positive(message = "поддерживаются только числовые значения")
    private Integer numCd;

    @NotBlank(message = "введите название")
    private String title;

    @Positive
    @NotNull
    private Integer releaseYear;

    @Positive
    @NotNull
    private Integer cost;

    @Positive
    @NotNull
    private Integer count;
}
