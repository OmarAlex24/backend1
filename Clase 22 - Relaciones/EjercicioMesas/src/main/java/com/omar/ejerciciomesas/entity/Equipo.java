package com.omar.ejerciciomesas.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "equipos")
public class Equipo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nombre;

    @Column
    private String ciudad;

    @OneToMany(mappedBy = "equipo", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JsonIdentityReference
    private Set<Jugador> jugadorList = new HashSet<>();
}
