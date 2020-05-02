package com.course.work.cdrent.genre.repository;

import com.course.work.cdrent.genre.entity.GenreCdEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreCdRepository extends JpaRepository<GenreCdEntity, Integer> {
}
