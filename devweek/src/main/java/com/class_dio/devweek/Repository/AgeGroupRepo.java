package com.class_dio.devweek.Repository;

import com.class_dio.devweek.Entity.AgeGroup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgeGroupRepo extends JpaRepository<AgeGroup, Long> {
}