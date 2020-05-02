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
    private Integer numCd;
    @NotBlank
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
