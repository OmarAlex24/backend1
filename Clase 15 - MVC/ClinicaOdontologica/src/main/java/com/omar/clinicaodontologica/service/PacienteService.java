package com.omar.clinicaodontologica.service;


import com.omar.clinicaodontologica.dao.PacienteDAOH2;
import com.omar.clinicaodontologica.dao.iDao;
import com.omar.clinicaodontologica.model.Paciente;
import org.springframework.stereotype.Service;

import java.util.List;

public class PacienteService {
    private iDao<Paciente> PacienteiDao;

    public PacienteService() {
        PacienteiDao = new PacienteDAOH2();
    }

    public Paciente guardarPaciente(Paciente paciente){
        return PacienteiDao.guardar(paciente);
    }

    public List<Paciente> buscarTodosLosPacientes(){return PacienteiDao.listarTodos();}

    public Paciente buscarPorID(Integer id){
        return PacienteiDao.buscarPorID(id);
    }

    public Paciente buscarPorEmail(String email){return PacienteiDao.buscarPorString(email);}

    public void actualizarPaciente(Paciente paciente){
        PacienteiDao.actualizar(paciente);
    }
}
