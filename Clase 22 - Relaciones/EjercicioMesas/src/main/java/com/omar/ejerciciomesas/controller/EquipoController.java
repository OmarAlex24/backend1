package com.omar.ejerciciomesas.controller;

import com.omar.ejerciciomesas.entity.Equipo;
import com.omar.ejerciciomesas.service.EquipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/equipos")
public class EquipoController {
    @Autowired
    private EquipoService equipoService;

    @GetMapping
    public List<Equipo> listarEquipos(){
        return equipoService.listarEquipos();
    }

    @PostMapping
    public Equipo guardarEquipo(@RequestBody Equipo equipo){
        return equipoService.guardarEquipo(equipo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarEquipo(@PathVariable Long id){
        Optional<Equipo> equipo = equipoService.obtenerEquipoPorId(id);

        if(equipo.isEmpty()){
            return ResponseEntity.badRequest().body("Equipo no encontrado");
        }
        equipoService.eliminarEquipoPorId(equipo.get().getId());
        return ResponseEntity.ok("Equipo eliminado");
    }
}
