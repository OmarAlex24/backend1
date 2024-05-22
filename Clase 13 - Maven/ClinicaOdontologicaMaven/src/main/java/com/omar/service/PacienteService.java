package com.omar.service;

import com.omar.dao.PacienteDAOH2;
import com.omar.dao.iDao;
import com.omar.model.Paciente;

public class PacienteService {
    private iDao<Paciente> PacienteiDao;

    public PacienteService() {
        PacienteiDao = new PacienteDAOH2();
    }

    public Paciente guardarPaciente(Paciente paciente){
        return PacienteiDao.guardar(paciente);
    }

    public Paciente buscarPorID(Integer id){
        return PacienteiDao.buscarPorID(id);
    }
}
