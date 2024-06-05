package com.omar.ejercicioclase.controller;

import com.omar.ejercicioclase.entity.Profesor;
import com.omar.ejercicioclase.service.ProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/profesores")
public class ProfesorController {
    @Autowired
    private ProfesorService profesorService;

    @GetMapping
    public List<Profesor> listarProfesores(){
        return profesorService.listarProfesores();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Profesor>> mostrarProfesorPorId(@PathVariable Long id){
        Optional<Profesor> profesor = profesorService.mostrarProfesorPorId(id);

        if(profesor.isEmpty()) return ResponseEntity.badRequest().build();

        return ResponseEntity.ok(profesor);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarProfesorPorId(@PathVariable Long id){
        Optional<Profesor> profesor = profesorService.mostrarProfesorPorId(id);

        if(profesor.isEmpty()) return ResponseEntity.badRequest().body("Profesor no encontrado");

        return ResponseEntity.ok("Profesor eliminado con exito");
    }


}
