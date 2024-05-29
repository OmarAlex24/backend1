package com.omar.clinicaodontologica.service;

import com.omar.clinicaodontologica.dao.OdontologoDAOH2;
import com.omar.clinicaodontologica.dao.OdontologoDAOList;
import com.omar.clinicaodontologica.dao.iDao;
import com.omar.clinicaodontologica.model.Odontologo;

import java.util.List;

public class OdontologoService {
    private iDao<Odontologo> OdontologoiDaoList;
    private iDao<Odontologo> OdontologoiDaoH2;

    public OdontologoService() {
        OdontologoiDaoH2 = new OdontologoDAOH2();
        OdontologoiDaoList = new OdontologoDAOList();
    }

    public Odontologo guardarOdontologoBD(Odontologo odontologo){
        return OdontologoiDaoH2.guardar(odontologo);
    }

    public List<Odontologo> listarOdontologosBD(){
        return OdontologoiDaoH2.listarTodos();
    }

    public Odontologo buscarOdontologoPorIdBD(Integer id){
        return OdontologoiDaoH2.buscarPorID(id);
    }

    public Odontologo buscarOdontologoPorMatricula(String matricula){
        return OdontologoiDaoH2.buscarPorString(matricula);
    }

    public Odontologo guardarOdontologoList(Odontologo odontologo){
        return OdontologoiDaoList.guardar(odontologo);
    }

    public List<Odontologo> listarOdontologosList(){
        return OdontologoiDaoList.listarTodos();
    }

    public void eliminarOdontologoPorId(Integer id){
        OdontologoiDaoH2.eliminar(id);
    }

    public void modificarOdontologo(Odontologo odontologo){
        OdontologoiDaoH2.actualizar(odontologo);
    }

}
