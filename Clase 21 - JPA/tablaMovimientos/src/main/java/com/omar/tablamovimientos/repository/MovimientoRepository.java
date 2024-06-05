package com.omar.tablamovimientos.repository;

import com.omar.tablamovimientos.entity.Movimiento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovimientoRepository extends JpaRepository<Movimiento, Long> {
    //Queries personalizadas
}
