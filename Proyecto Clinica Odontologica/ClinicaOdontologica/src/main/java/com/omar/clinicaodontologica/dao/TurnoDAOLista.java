package com.omar.clinicaodontologica.dao;

import com.omar.clinicaodontologica.model.Odontologo;
import com.omar.clinicaodontologica.model.Paciente;
import com.omar.clinicaodontologica.model.Turno;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class TurnoDAOLista implements iDao<Turno>{
    private static Integer id = 0;
    private Logger logger = Logger.getLogger(TurnoDAOLista.class);
    private List<Turno> turnos = new ArrayList<>();

    @Override
    public Turno guardar(Turno turno) {
        logger.info("Iniciando las operaciones de guardado de turno");

        PacienteDAOH2 pacienteDAOH2 = new PacienteDAOH2();
        OdontologoDAOH2 odontologoDAOH2 = new OdontologoDAOH2();
        turno.setId(++id);
        turno.setPaciente(pacienteDAOH2.buscarPorID(turno.getPaciente().getId()));
        turno.setOdontologo(odontologoDAOH2.buscarPorID(turno.getOdontologo().getId()));
        turnos.add(turno);
        logger.info("Turno guardado con exito");

        return turno;
    }

    @Override
    public Turno buscarPorID(Integer id) {
        for (Turno turno : turnos) {
            if(turno.getId().equals(id)){
                return turno;
            }
        }
        return null;
    }

    @Override
    public void eliminar(Integer id) {
        logger.info("Iniciando las operaciones de eliminacion de turno del id: "+id);
        Turno turnoBuscado = buscarPorID(id);

        if(turnoBuscado != null){
            turnos.remove(turnoBuscado);
        }
    }

    @Override
    public void actualizar(Turno turnoModificado) {
        logger.info("Iniciando las operaciones de actualizar");

        PacienteDAOH2 pacienteDAOH2 = new PacienteDAOH2();
        OdontologoDAOH2 odontologoDAOH2 = new OdontologoDAOH2();

        Odontologo odontologo = odontologoDAOH2.buscarPorID(turnoModificado.getOdontologo().getId());
        Paciente paciente = pacienteDAOH2.buscarPorID(turnoModificado.getPaciente().getId());

        for (Turno turnoReemplazar : turnos) {
            if(turnoReemplazar.getId().equals(turnoModificado.getId())){
                turnoReemplazar.setPaciente(paciente);
                turnoReemplazar.setOdontologo(odontologo);
                turnoReemplazar.setFecha(turnoModificado.getFecha());
                logger.info("Turno modificado");
            }
        }
    }

    @Override
    public List<Turno> listarTodos() {
        logger.info("Iniciando las operaciones de mostrar todos los turnos");
        return turnos;
    }

    @Override
    public Turno buscarPorString(String string) {
        return null;
    }
}
