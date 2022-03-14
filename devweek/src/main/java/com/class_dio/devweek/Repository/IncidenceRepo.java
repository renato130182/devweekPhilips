package com.class_dio.devweek.Repository;

import com.class_dio.devweek.Entity.Incidence;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IncidenceRepo extends JpaRepository<Incidence, Long> {
}