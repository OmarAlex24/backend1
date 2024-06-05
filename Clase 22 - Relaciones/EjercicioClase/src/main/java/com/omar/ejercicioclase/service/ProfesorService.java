package com.omar.ejercicioclase.service;

import com.omar.ejercicioclase.entity.Profesor;
import com.omar.ejercicioclase.repository.ProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfesorService {
    @Autowired
    private ProfesorRepository profesorRepository;

    public Profesor guardarProfesor(Profesor profesor){
        return profesorRepository.save(profesor);
    }

    public Optional<Profesor> mostrarProfesorPorId(Long id){
        return profesorRepository.findById(id);
    }

    public void actualizarProfesor(Profesor profesor){
        profesorRepository.save(profesor);
    }

    public List<Profesor> listarProfesores(){
        return profesorRepository.findAll();
    }

    public void eliminarProfesorById(Long id){
        profesorRepository.deleteById(id);
    }
}
