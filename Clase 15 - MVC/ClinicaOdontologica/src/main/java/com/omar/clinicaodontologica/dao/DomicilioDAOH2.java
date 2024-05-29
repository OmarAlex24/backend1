package com.omar.clinicaodontologica.dao;

import com.omar.clinicaodontologica.model.Domicilio;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

public class DomicilioDAOH2 implements iDao<Domicilio> {
    public static final Logger logger = Logger.getLogger(DomicilioDAOH2.class);

    private static final String SQL_SELECT_ONE = "SELECT * FROM DOMICILIOS WHERE ID = ?";

    private static final String SQL_INSERT = "INSERT INTO DOMICILIOS (CALLE, NUMERO, LOCALIDAD, PROVINCIA) VALUES(?,?,?,?)";

    private static final String SQL_UPDATE = "UPDATE DOMICILIOS SET CALLE=?, NUMERO=?, LOCALIDAD=?, PROVINCIA=? WHERE ID=?";

//    private Integer id;
//    private String calle;
//    private Integer numero;
//    private String localidad;
//    private String provincia;

    @Override
    public Domicilio guardar(Domicilio domicilio) {
        logger.info("Guardando domicilio con id "+domicilio.getId());
        Connection connection = null;

        try {
            connection = BD.getConnection();
            PreparedStatement psInsert = connection.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);

            psInsert.setString(1, domicilio.getCalle());
            psInsert.setInt(2,domicilio.getNumero());
            psInsert.setString(3, domicilio.getLocalidad());
            psInsert.setString(4, domicilio.getProvincia());
            psInsert.execute();

            ResultSet clave = psInsert.getGeneratedKeys();

            while (clave.next()){
                domicilio.setId(clave.getInt(1));
            }

            logger.info("Domicilio guardado con exito");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return domicilio;
    }

    @Override
    public Domicilio buscarPorID(Integer id) {
        logger.info("Buscando el domicilio...");

        Connection connection = null;
        Domicilio domicilio = null;

        try{
            connection = BD.getConnection();
            Statement statement = connection.createStatement();
            PreparedStatement psSelectOne = connection.prepareStatement(SQL_SELECT_ONE);
            psSelectOne.setInt(1,id);
            ResultSet rs = psSelectOne.executeQuery();

            while(rs.next()){
                domicilio = new Domicilio(id, rs.getString(2),rs.getInt(3),rs.getString(4),rs.getString(5));
            }

        }catch (Exception e){
            logger.warn(e.getMessage());
        }
        logger.info("Domicilio encontrado!");
        return domicilio;
    }

    @Override
    public void eliminar(Integer id) {

    }

    @Override
    public void actualizar(Domicilio domicilio) {
        logger.info("Iniciando operaciones de actualizacion al domicilio con id: "+domicilio.getId());
        Connection connection = null;

        try {
            connection = BD.getConnection();
            PreparedStatement psUpdate = connection.prepareStatement(SQL_UPDATE);

            psUpdate.setString(1, domicilio.getCalle());
            psUpdate.setInt(2,domicilio.getNumero());
            psUpdate.setString(3, domicilio.getLocalidad());
            psUpdate.setString(4, domicilio.getProvincia());
            psUpdate.setInt(5, domicilio.getId());
            psUpdate.execute();

        } catch (Exception e) {
            logger.warn(e.getMessage());
        }
    }

    @Override
    public List<Domicilio> listarTodos() {
        return List.of();
    }

    @Override
    public Domicilio buscarPorString(String string) {
        return null;
    }
}
