package com.course.work.cdrent.listgenre.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Embeddable
@Table(name = "list_genre")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class ListGenreEntity {
    @Id
    @Column(name = "num_genre")
    private Integer numGenre;
    @Column(name = "genre")
    private String genre;
}
