package com.omar.ejercicioclase.repository;

import com.omar.ejercicioclase.entity.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfesorRepository extends JpaRepository<Profesor,Long> {
}
