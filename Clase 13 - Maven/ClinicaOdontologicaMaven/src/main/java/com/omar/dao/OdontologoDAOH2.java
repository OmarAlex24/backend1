package com.omar.dao;

import com.omar.model.Odontologo;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class OdontologoDAOH2 implements iDao<Odontologo>{

    private static final Logger logger = Logger.getLogger(OdontologoDAOH2.class);

    private static final String SQL_INSERT = "INSERT INTO ODONTOLOGOS VALUES(?,?,?)";
    private static final String SQL_CONSULT_ALL = "SELECT * FROM ODONTOLOGOS";


    @Override
    public Odontologo guardar(Odontologo odontologo) {
        Connection connection = null;

        try{
            connection = BD.getConnection();
            PreparedStatement psInsert = connection.prepareStatement(SQL_INSERT);

            psInsert.setInt(1,odontologo.getMatricula());
            psInsert.setString(2,odontologo.getNombre());
            psInsert.setString(3,odontologo.getApellido());
            psInsert.execute();

            logger.info("Se inserto correctamente el odontologo en la BD");

        } catch (Exception e) {
            logger.warn(e.getMessage());
        }
        return odontologo;
    }

    @Override
    public Odontologo buscarPorID(Integer id) {
        return null;
    }

    @Override
    public void eliminar(Integer id) {

    }

    @Override
    public void actualizar(Odontologo odontologo) {

    }

    @Override
    public List<Odontologo> listarTodos() {
        List<Odontologo> listaOdontologos = new ArrayList<>();

        Connection connection = null;

        try {
            connection = BD.getConnection();
            Statement statement = connection.createStatement();
            ResultSet rsConsultAll = statement.executeQuery(SQL_CONSULT_ALL);

            while(rsConsultAll.next()){
                listaOdontologos.add(new Odontologo(rsConsultAll.getInt(1), rsConsultAll.getString(2), rsConsultAll.getString(3)));
            }
            logger.info("Devolviendo lista BD");

        } catch (Exception e){
            logger.warn(e.getMessage());
        }
        return listaOdontologos;
    }
}
