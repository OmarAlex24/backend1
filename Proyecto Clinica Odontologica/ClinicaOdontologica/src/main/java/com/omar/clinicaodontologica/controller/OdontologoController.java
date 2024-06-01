package com.omar.clinicaodontologica.controller;

import com.omar.clinicaodontologica.model.Odontologo;
import com.omar.clinicaodontologica.service.OdontologoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("odontologos")
public class OdontologoController {

    private OdontologoService odontologoService;

    public OdontologoController(){
        odontologoService = new OdontologoService();
    }

    @PostMapping
    public Odontologo agregarOdontologo(@RequestBody Odontologo odontologo){
        return odontologoService.guardarOdontologoBD(odontologo);
    }

    @GetMapping
    public ResponseEntity<List<Odontologo>> mostrarTodosLosOdontologos(){
        return ResponseEntity.ok(odontologoService.listarOdontologosBD());
    }

    @GetMapping("/{id}")
    public Odontologo mostrarOdontologoPorId (@PathVariable Integer id){
        return odontologoService.buscarOdontologoPorIdBD(id);
    }

    @GetMapping("/matricula/{matricula}")
    public Odontologo mostrarOdontologoPorMatricula (@PathVariable String matricula){
        return odontologoService.buscarOdontologoPorMatricula(matricula);
    }

    @DeleteMapping("/{id}")
    public void eliminarOdontologoPorId (@PathVariable Integer id){
        odontologoService.eliminarOdontologoPorId(id);
    }

    @PutMapping
    public void modificarOdontologo(@RequestBody Odontologo odontologo){
        odontologoService.modificarOdontologo(odontologo);
    }
}
