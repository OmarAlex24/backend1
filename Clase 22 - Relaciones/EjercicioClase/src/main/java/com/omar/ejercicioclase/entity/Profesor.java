package com.omar.ejercicioclase.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "profesores")
public class Profesor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column
    private String nombre;

    @Column
    private String titulo;

    @OneToMany(mappedBy = "profesor", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private Set<Estudiante> estudiantes = new HashSet<>();
}
