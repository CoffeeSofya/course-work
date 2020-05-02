package com.course.work.cdrent.rental.repository;

import com.course.work.cdrent.rental.entity.RentalEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentalRepository extends JpaRepository<RentalEntity, Integer> {
}
