package com.course.work.cdrent.cd.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Embeddable
@Table(name = "cd")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class CDEntity {
    @Id
    @Column(name = "num_cd")
    private Integer numCd;
    @Column(name = "title")
    private String title;
    @Column(name = "release_year")
    private Integer releaseYear;
    @Column(name = "cost_cd")
    private Integer cost;
    @Column(name = "count_cd")
    private Integer count;
}

