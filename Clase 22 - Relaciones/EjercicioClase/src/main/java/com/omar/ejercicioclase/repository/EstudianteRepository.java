package com.omar.ejercicioclase.repository;

import com.omar.ejercicioclase.entity.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstudianteRepository extends JpaRepository<Estudiante,Long> {
}
