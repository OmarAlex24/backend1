package com.omar.ejerciciomesas.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import com.omar.ejerciciomesas.entity.Equipo;

@Getter
@Setter
@Entity
@Table(name = "jugadores")

public class Jugador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nombre;

    @Column
    private String puesto;

    @Column
    private String ciudad;

    @ManyToOne
    @JoinColumn(name = "equipo_id", nullable = false)
    @JsonBackReference
    private Equipo equipo;
}
