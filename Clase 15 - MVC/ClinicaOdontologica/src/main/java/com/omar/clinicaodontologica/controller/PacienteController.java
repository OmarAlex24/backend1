package com.omar.clinicaodontologica.controller;

import lombok.Getter;
import org.springframework.ui.Model;
import com.omar.clinicaodontologica.model.Paciente;
import com.omar.clinicaodontologica.service.PacienteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    private PacienteService pacienteService;

    public PacienteController() {
        pacienteService = new PacienteService();
    }

    @GetMapping
    public List<Paciente> listarTodosLosPacientes(){
        return pacienteService.buscarTodosLosPacientes();
    }

    @GetMapping("/{id}")
    public Paciente mostrarPacientePorId(@PathVariable Integer id){
        return pacienteService.buscarPorID(id);
    }

    @PostMapping
    public Paciente guardarPaciente(@RequestBody Paciente paciente){
        return pacienteService.guardarPaciente(paciente);
    }

    @PutMapping
    public String actualizarPaciente(@RequestBody Paciente paciente){
        Paciente pacienteBuscado = pacienteService.buscarPorID(paciente.getId());

        if(pacienteBuscado!=null){
            pacienteService.actualizarPaciente(paciente);
            return "Paciente actualizado con exito";
        }

        return "Paciente ya existe";
    }
}
