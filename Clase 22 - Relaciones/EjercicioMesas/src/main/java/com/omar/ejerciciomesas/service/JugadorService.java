package com.omar.ejerciciomesas.service;

import com.omar.ejerciciomesas.entity.Equipo;
import com.omar.ejerciciomesas.entity.Jugador;
import com.omar.ejerciciomesas.repository.JugadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JugadorService {
    @Autowired
    private JugadorRepository jugadorRepository;

    public Optional<Jugador> obtenerJugadorPorId(Long id){
        return jugadorRepository.findById(id);
    }

    public Jugador guardarJugador(Jugador jugador){
        return jugadorRepository.save(jugador);
    }

    public void eliminarJugador(Long id){
        jugadorRepository.deleteById(id);
    }

    public List<Jugador> listarJugadores(){
        return jugadorRepository.findAll();
    }
}
