package com.omar.clinicaodontologica.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@ToString
public class Turno {
    private Integer id;
    private Paciente paciente;
    private Odontologo odontologo;
    private LocalDate fecha;
}
