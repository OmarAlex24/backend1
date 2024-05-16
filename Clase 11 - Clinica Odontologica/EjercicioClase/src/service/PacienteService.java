package service;

import dao.PacienteDAOH2;
import dao.iDao;
import module.Paciente;

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
