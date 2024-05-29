package com.omar.clinicaodontologica.dao;
import org.apache.log4j.Logger;

import com.omar.clinicaodontologica.model.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class PacienteDAOH2 implements iDao<Paciente> {
    private static final Logger logger = Logger.getLogger(PacienteDAOH2.class);

    private static final String SQL_SELECT_ONE = "SELECT * FROM PACIENTES WHERE ID = ?";
    private static final String SQL_SELECT_ALL = "SELECT * FROM PACIENTES";
    private static final String SQL_INSERT = "INSERT INTO PACIENTES (NOMBRE, APELLIDO, CEDULA, FECHA_INGRESO, DOMICILIO_ID, EMAIL) VALUES(?,?,?,?,?,?)";
    private static final String SQL_SELECT_BY_EMAIL = "SELECT * FROM PACIENTES WHERE EMAIL = ?";
    private static final String SQL_UPDATE_PACIENTE = "UPDATE PACIENTES SET NOMBRE=?, APELLIDO=?, CEDULA=?, FECHA_INGRESO=?,DOMICILIO_ID=?, EMAIL=? WHERE ID=?";
    private static final String SQL_DELETE = "DELETE FROM PACIENTES WHERE ID=?";

//    private Integer id;
//    private String nombre;
//    private String apellido;
//    private String cedula;
//    private LocalDate fechaIngreso;
//    private Domicilio domicilio;

    @Override
    public Paciente guardar(Paciente paciente) {
        logger.info("Guardando paciente "+ paciente.getNombre());

        Connection connection = null;

        DomicilioDAOH2 daoAux = new DomicilioDAOH2();
        Domicilio domicilio = daoAux.guardar(paciente.getDomicilio());

        try{
            connection = BD.getConnection();
            PreparedStatement psInsert = connection.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);

            psInsert.setString(1, paciente.getNombre());
            psInsert.setString(2, paciente.getApellido());
            psInsert.setString(3, paciente.getCedula());
            psInsert.setDate(4, Date.valueOf(paciente.getFechaIngreso()));
            psInsert.setInt(5, domicilio.getId());
            psInsert.setString(6, paciente.getEmail());
            psInsert.execute();

            ResultSet clave = psInsert.getGeneratedKeys();

            while(clave.next()){
                paciente.setId(clave.getInt(1));
            }

            logger.info("Paciente guardado");

        } catch (Exception e){
            logger.warn(e.getMessage());
        }
        return paciente;
    }

    @Override
    public Paciente buscarPorID(Integer id) {
        logger.info("Buscando el paciente...");

        Connection connection = null;
        Paciente paciente = null;
        Domicilio domicilio = null;
        DomicilioDAOH2 domicilioDAOH2 = new DomicilioDAOH2();

        try{
            connection = BD.getConnection();
            Statement statement = connection.createStatement();
            PreparedStatement psSelectOne = connection.prepareStatement(SQL_SELECT_ONE);
            psSelectOne.setInt(1,id);
            ResultSet rs = psSelectOne.executeQuery();

            while(rs.next()){
                domicilio = domicilioDAOH2.buscarPorID(rs.getInt(6));
                paciente = new Paciente(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDate(5).toLocalDate(),domicilio, rs.getString(7));
            }

        }catch (Exception e){
            logger.warn(e.getMessage());
        }

        return paciente;
    }

    @Override
    public void eliminar(Integer id) {
        logger.info("Iniciando las operaciones de eliminacion del paciente con id: "+id);
        Connection connection = null;

        try {
            connection = BD.getConnection();
            PreparedStatement psDelete = connection.prepareStatement(SQL_DELETE);
            psDelete.setInt(1,id);
            psDelete.executeQuery();

        } catch (Exception e) {
            logger.warn(e.getMessage());
        }

    }

    @Override
    public void actualizar(Paciente paciente) {
        logger.info("Iniciando las operaciones de actualizacion del paciente con id: "+paciente.getId());
        Connection connection = null;
        DomicilioDAOH2 domicilioDAOH2 = new DomicilioDAOH2();

        try{
            connection = BD.getConnection();
            domicilioDAOH2.actualizar(paciente.getDomicilio());
            PreparedStatement psUpdate = connection.prepareStatement(SQL_UPDATE_PACIENTE);

            psUpdate.setString(1, paciente.getNombre());
            psUpdate.setString(2, paciente.getApellido());
            psUpdate.setString(3, paciente.getCedula());
            psUpdate.setDate(4, Date.valueOf(paciente.getFechaIngreso()));
            psUpdate.setInt(5, paciente.getDomicilio().getId());
            psUpdate.setString(6, paciente.getEmail());
            psUpdate.setInt(7, paciente.getId());
            psUpdate.execute();

        } catch (Exception e) {
            logger.warn(e.getMessage());
        }
    }

    @Override
    public List<Paciente> listarTodos() {
        logger.info("Iniciando las operaciones de busqueda...");
        Connection connection = null;
        List<Paciente> pacienteList = new ArrayList<>();
        Paciente paciente = null;
        Domicilio domicilio = null;

        try{
            connection = BD.getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(SQL_SELECT_ALL);
            DomicilioDAOH2 domicilioDAOH2 = new DomicilioDAOH2();

            while(rs.next()){
                domicilio = domicilioDAOH2.buscarPorID(rs.getInt(6));

                paciente = new Paciente(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getDate(5).toLocalDate(),
                        domicilio,
                        rs.getString(7));

                pacienteList.add(paciente);
                logger.info("Paciente agregado a la lista");
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return pacienteList;
    }

    @Override
    public Paciente buscarPorString(String string) {
        Connection connection = null;
        Paciente paciente = null;
        Domicilio domicilio = null;
        DomicilioDAOH2 domicilioDAOH2 = new DomicilioDAOH2();

        try {
            connection = BD.getConnection();
            PreparedStatement psSearchByEmail = connection.prepareStatement(SQL_SELECT_BY_EMAIL);
            psSearchByEmail.setString(1, string);
            ResultSet rsEmail = psSearchByEmail.executeQuery();
            logger.info("Buscando paciente por email: "+string);

            if (rsEmail.next()){
                domicilio = domicilioDAOH2.buscarPorID(rsEmail.getInt(6));
                paciente = new Paciente(rsEmail.getInt(1),rsEmail.getString(2),rsEmail.getString(3),rsEmail.getString(4),rsEmail.getDate(5).toLocalDate(),domicilio,rsEmail.getString(7));
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return paciente;
    }
}
