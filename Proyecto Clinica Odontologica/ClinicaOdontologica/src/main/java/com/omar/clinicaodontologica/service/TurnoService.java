package com.omar.clinicaodontologica.service;

import com.omar.clinicaodontologica.dao.TurnoDAOLista;
import com.omar.clinicaodontologica.dao.iDao;
import com.omar.clinicaodontologica.model.Turno;

import java.util.List;

public class TurnoService {
    private iDao<Turno> turnoiDao;

    public TurnoService(){
        turnoiDao = new TurnoDAOLista();
    }

    public Turno guardarTurno(Turno turno){
        return turnoiDao.guardar(turno);
    }
    public List<Turno> listarTodosLosTurnos(){
        return turnoiDao.listarTodos();
    }

    public Turno buscarTurnoPorId(Integer id){
        return turnoiDao.buscarPorID(id);
    }

    public void modificarTurno(Turno turno){
        turnoiDao.actualizar(turno);
    }

    public void eliminarTurnoPorId(Integer id){
        turnoiDao.eliminar(id);
    }
}
