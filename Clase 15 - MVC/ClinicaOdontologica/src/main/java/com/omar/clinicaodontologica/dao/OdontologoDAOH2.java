package com.omar.clinicaodontologica.dao;


import com.omar.clinicaodontologica.model.Odontologo;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class OdontologoDAOH2 implements iDao<Odontologo>{

    private static final Logger logger = Logger.getLogger(OdontologoDAOH2.class);

    private static final String SQL_INSERT = "INSERT INTO ODONTOLOGOS (MATRICULA, NOMBRE, APELLIDO) VALUES(?,?,?)";
    private static final String SQL_SELECT_ALL = "SELECT * FROM ODONTOLOGOS";
    private static final String SQL_SELECT_BY_ID = "SELECT * FROM ODONTOLOGOS WHERE ID = ?";
    private static final String SQL_SELECT_BY_MATRICULA = "SELECT * FROM ODONTOLOGOS WHERE MATRICULA = ?";
    private static final String SQL_UPDATE = "UPDATE ODONTOLOGOS SET MATRICULA=?, NOMBRE=?, APELLIDO=? WHERE ID=?";
    private static final String SQL_DELETE = "DELETE FROM ODONTOLOGOS WHERE ID=?";


    @Override
    public Odontologo guardar(Odontologo odontologo) {
        Connection connection = null;

        try{
            connection = BD.getConnection();
            PreparedStatement psInsert = connection.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);

            psInsert.setString(1,odontologo.getMatricula());
            psInsert.setString(2,odontologo.getNombre());
            psInsert.setString(3,odontologo.getApellido());
            psInsert.execute();

            ResultSet clave = psInsert.getGeneratedKeys();

            while (clave.next()){
                odontologo.setId(clave.getInt(1));
            }
            logger.info("Se inserto correctamente el odontologo en la BD");

        } catch (Exception e) {
            logger.warn(e.getMessage());
        }
        return odontologo;
    }

    @Override
    public Odontologo buscarPorID(Integer id) {
        Odontologo odontologo = null;
        Connection connection = null;

        try{
            logger.info("Conexion a bd exitosa");
            connection = BD.getConnection();
            PreparedStatement psSelectById = connection.prepareStatement(SQL_SELECT_BY_ID);
            psSelectById.setInt(1,id);
            ResultSet rs = psSelectById.executeQuery();

            while(rs.next()){
                odontologo = new Odontologo(id,rs.getString(2),rs.getString(3),rs.getString(4));
            }

        } catch (Exception e) {
            logger.warn(e.getMessage());
        }
        logger.info("Usuario encontrado");
        return odontologo;
    }

    @Override
    public void eliminar(Integer id) {
        logger.info("Iniciando las operaciones de eliminacion del odontologo con id: "+id);

        Odontologo odontologo = null;
        Connection connection = null;

        try{
            connection = BD.getConnection();
            PreparedStatement psSelectById = connection.prepareStatement(SQL_DELETE);
            psSelectById.setInt(1, id);
            psSelectById.execute();

        } catch (Exception e) {
            logger.warn(e.getMessage());
        }
    }

    @Override
    public void actualizar(Odontologo odontologo) {
        logger.info("Iniciando las operaciones de actualizar el odontologo con id: "+odontologo.getId());

        Connection connection = null;

        try{
            connection = BD.getConnection();
            PreparedStatement psUpdate = connection.prepareStatement(SQL_UPDATE);
            psUpdate.setString(1, odontologo.getMatricula());
            psUpdate.setString(2, odontologo.getNombre());
            psUpdate.setString(3, odontologo.getApellido());
            psUpdate.setInt(4, odontologo.getId());

            psUpdate.execute();

        } catch (Exception e) {
            logger.warn(e.getMessage());
        }
        logger.info("Odontologo actualizado con exito");
    }

    @Override
    public List<Odontologo> listarTodos() {
        List<Odontologo> listaOdontologos = new ArrayList<>();
        Odontologo odontologo = null;
        Connection connection = null;

        try {
            connection = BD.getConnection();
            Statement statement = connection.createStatement();
            ResultSet rsConsultAll = statement.executeQuery(SQL_SELECT_ALL);

            while(rsConsultAll.next()){
                odontologo = new Odontologo(rsConsultAll.getInt(1),rsConsultAll.getString(2), rsConsultAll.getString(3), rsConsultAll.getString(4));
                listaOdontologos.add(odontologo);
            }
            logger.info("Devolviendo lista de odontologos");

        } catch (Exception e){
            logger.warn(e.getMessage());
        }
        return listaOdontologos;
    }

    @Override
    public Odontologo buscarPorString(String matricula) {
        Odontologo odontologo = null;
        Connection connection = null;

        try {
            connection = BD.getConnection();
            PreparedStatement psConsultMatricula = connection.prepareStatement(SQL_SELECT_BY_MATRICULA);
            psConsultMatricula.setString(1, matricula);
            ResultSet rsMatricula = psConsultMatricula.executeQuery();

            while (rsMatricula.next()){
                odontologo = new Odontologo(rsMatricula.getInt(1),rsMatricula.getString(2), rsMatricula.getString(3),rsMatricula.getString(4));
            }

        } catch (Exception e){
            logger.warn(e.getMessage());
        }
        return odontologo;
    }
}
