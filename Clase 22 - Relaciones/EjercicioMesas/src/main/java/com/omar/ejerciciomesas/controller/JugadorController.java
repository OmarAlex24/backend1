package com.omar.ejerciciomesas.controller;

import com.omar.ejerciciomesas.entity.Equipo;
import com.omar.ejerciciomesas.entity.Jugador;
import com.omar.ejerciciomesas.service.JugadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/jugadores")
public class JugadorController {
    @Autowired
    private JugadorService jugadorService;

    @GetMapping
    public List<Jugador> listarJugadores(){
        return jugadorService.listarJugadores();
    }

    @GetMapping("/{id}")
    public Optional<Jugador> buscarJugadorPorId(@PathVariable Long id){
        return null;
    }

    @PostMapping
    public ResponseEntity<Jugador> guardarJugador(@RequestBody Jugador jugador){
        return ResponseEntity.ok(jugadorService.guardarJugador(jugador));
    }

}
