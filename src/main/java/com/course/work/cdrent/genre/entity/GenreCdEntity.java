package com.course.work.cdrent.genre.entity;

import com.course.work.cdrent.cd.entity.CDEntity;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Embeddable
@Table(name = "genre_cd")
@NoArgsConstructor
@Getter
@Setter
public class GenreCdEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "num_cd")
    private Integer numCd;
    @Column(name = "num_genre")
    private Integer numGenre;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinTable(name = "cd")
    private CDEntity cdEntity;
}
