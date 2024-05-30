package com.omar.clinicaodontologica.model;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class Odontologo {
    private Integer id;
    private String matricula;
    private String nombre;
    private String apellido;

    public Odontologo(String matricula, String nombre, String apellido) {
        this.matricula = matricula;
        this.nombre = nombre;
        this.apellido = apellido;
    }
}

