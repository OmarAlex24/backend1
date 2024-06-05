package com.omar.ejercicioclase.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "estudiantes")
public class Estudiante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column
    private String nombre;

    @Column
    private Integer edad;

    @ManyToOne
    private Profesor profesor;
}
