package com.course.work.cdrent.infocd.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class InfoCdDto {
    private String title;
    private Integer releaseYear;
    private Integer cost;
    private Integer count;
    private List<String> genres;
}
