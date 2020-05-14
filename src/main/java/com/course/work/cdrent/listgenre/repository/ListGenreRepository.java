package com.course.work.cdrent.listgenre.repository;

import com.course.work.cdrent.listgenre.entity.ListGenreEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ListGenreRepository extends JpaRepository<ListGenreEntity, Integer> {
    @Query("SELECT g " +
            "FROM ListGenreEntity g " +
            "JOIN GenreCdEntity gc on gc.numGenre = g.numGenre " +
            "JOIN CDEntity c on c.numCd = gc.numCd " +
            "WHERE c.numCd = :num_cd")
    List<ListGenreEntity> getGenresForNumCd(@Param("num_cd") Integer numCd);
}
