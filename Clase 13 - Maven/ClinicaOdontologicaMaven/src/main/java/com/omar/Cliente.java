package com.omar;

import com.omar.dao.BD;
import com.omar.model.Domicilio;
import com.omar.model.Paciente;
import com.omar.service.PacienteService;

import java.time.LocalDate;

public class Cliente {
    public static void main(String[] args) {
        BD.crearTabla();
        Paciente paciente = new Paciente("Luisa","Toro","11111", LocalDate.of(2024,5,21), new Domicilio("Calle false",123,"Cali","Bogota"));
        PacienteService pacienteService = new PacienteService();

        pacienteService.guardarPaciente(paciente);
    }
}
