package com.course.work.cdrent.cd.repository;


import com.course.work.cdrent.cd.entity.CDEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CDRepository extends JpaRepository<CDEntity, Integer> {

    @Query("SELECT cd " +
            "FROM CDEntity cd " +
            "JOIN GenreCdEntity gce ON gce.numCd = cd.numCd " +
            "JOIN ListGenreEntity lge ON lge.numGenre = gce.numGenre " +
            "WHERE lge.numGenre = :numGenre")
    List<CDEntity> getCdForGenres(@Param("numGenre") Integer numGenre);
}
