package com.course.work.cdrent.listgenre.repository;

import com.course.work.cdrent.listgenre.entity.ListGenreEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ListGenreRepository extends JpaRepository<ListGenreEntity, Integer> {
}
