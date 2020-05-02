package com.course.work.cdrent.renter.repository;

import com.course.work.cdrent.renter.entity.RenterEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RenterRepository extends JpaRepository<RenterEntity, Integer> {
}