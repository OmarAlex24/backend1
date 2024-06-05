package com.omar.ejercicioclase.service;

import com.omar.ejercicioclase.entity.Estudiante;
import com.omar.ejercicioclase.repository.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstudianteService {
    @Autowired
    private EstudianteRepository estudianteRepository;

    public Estudiante guardarEstudiante(Estudiante estudiante){
        return estudianteRepository.save(estudiante);
    }

    public Optional<Estudiante> mostrarEstudiantePorId(Long id){
        return estudianteRepository.findById(id);
    }

    public void actualizarEstudiante(Estudiante estudiante){
        estudianteRepository.save(estudiante);
    }

    public List<Estudiante> listarEstudiantes(){
        return estudianteRepository.findAll();
    }

    public void eliminarEstudianteById(Long id){
        estudianteRepository.deleteById(id);
    }
}
