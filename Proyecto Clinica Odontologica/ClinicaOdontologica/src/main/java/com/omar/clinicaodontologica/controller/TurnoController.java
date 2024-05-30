package com.omar.clinicaodontologica.controller;

import com.omar.clinicaodontologica.model.Odontologo;
import com.omar.clinicaodontologica.model.Paciente;
import com.omar.clinicaodontologica.model.Turno;
import com.omar.clinicaodontologica.service.OdontologoService;
import com.omar.clinicaodontologica.service.PacienteService;
import com.omar.clinicaodontologica.service.TurnoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/turnos")
public class TurnoController {
    private TurnoService turnoService;
    PacienteService pacienteService;
    OdontologoService odontologoService ;

    public TurnoController(){
        turnoService = new TurnoService();
        pacienteService = new PacienteService();
        odontologoService = new OdontologoService();
    }

    @PostMapping
    public ResponseEntity<Turno> guardarTurnos(@RequestBody Turno turno){
        Paciente paciente = pacienteService.buscarPorID(turno.getPaciente().getId());
        Odontologo odontologo = odontologoService.buscarOdontologoPorIdBD(turno.getOdontologo().getId());

        if(paciente != null && odontologo != null){
            return ResponseEntity.ok(turnoService.guardarTurno(turno));
        }

        return ResponseEntity.badRequest().build();
    }

    @GetMapping
    public ResponseEntity<List<Turno>> listarTurnos(){
        return ResponseEntity.ok(turnoService.listarTodosLosTurnos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Turno> buscarTurnoPorId(@PathVariable Integer id){
        Turno turnoBuscado = turnoService.buscarTurnoPorId(id);

        if(turnoBuscado == null){
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(turnoBuscado);
    }

    @PutMapping
    public ResponseEntity<String> modificarTurno(@RequestBody Turno turno){
        Turno turnoAModificar = turnoService.buscarTurnoPorId(turno.getId());

        if(turnoAModificar == null){
            return ResponseEntity.badRequest().body("No existe un turno con ese id");
        }

        turnoService.modificarTurno(turno);
        return ResponseEntity.ok("Turno modificado");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarTurno(@PathVariable Integer id){
        Turno turnoAEliminar = turnoService.buscarTurnoPorId(id);

        if(turnoAEliminar == null){
            return ResponseEntity.badRequest().body("No existe un turno con ese id");
        }

        turnoService.eliminarTurnoPorId(id);
        return ResponseEntity.ok("Turno eliminado");
    }
}
