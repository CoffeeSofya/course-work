package com.course.work.cdrent.cd.entity;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Embeddable
@Table(name = "cd")
@NoArgsConstructor
@Getter
@Setter
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

    @OneToMany(mappedBy = "cdEntity")
    private Set<GernreCdEntity>;
}

