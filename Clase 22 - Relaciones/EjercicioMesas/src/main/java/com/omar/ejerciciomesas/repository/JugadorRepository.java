package com.omar.ejerciciomesas.repository;

import com.omar.ejerciciomesas.entity.Jugador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JugadorRepository extends JpaRepository<Jugador,Long> {
}
