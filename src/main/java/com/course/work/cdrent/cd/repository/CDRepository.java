package com.course.work.cdrent.cd.repository;


import com.course.work.cdrent.cd.entity.CDEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CDRepository extends JpaRepository<CDEntity, Integer> {
}
