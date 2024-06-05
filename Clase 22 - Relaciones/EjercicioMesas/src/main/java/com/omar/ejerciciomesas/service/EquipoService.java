package com.omar.ejerciciomesas.service;

import com.omar.ejerciciomesas.entity.Equipo;
import com.omar.ejerciciomesas.repository.EquipoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EquipoService {
    @Autowired
    private EquipoRepository equipoRepository;

    public Optional<Equipo> obtenerEquipoPorId(Long id){
        return equipoRepository.findById(id);
    }

    public Equipo guardarEquipo(Equipo equipo){
        return equipoRepository.save(equipo);
    }

    public void eliminarEquipoPorId(Long id){
        equipoRepository.deleteById(id);
    }

    public List<Equipo> listarEquipos(){
        return equipoRepository.findAll();
    }
}
