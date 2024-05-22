package com.omar.dao;

import com.omar.model.Domicilio;
import com.omar.model.Paciente;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PacienteDAOH2 implements iDao<Paciente> {
    private static final Logger logger = Logger.getLogger(PacienteDAOH2.class);

    private static final String SQL_SELECT_ONE = "SELECT * FROM PACIENTES WHERE ID = ?";

    private static final String SQL_SELECT_ALL = "SELECT * FROM PACIENTES";

    private static final String SQL_INSERT = "INSERT INTO PACIENTES (NOMBRE, APELLIDO, CEDULA, FECHA_INGRESO, DOMICILIO_ID) VALUES(?,?,?,?,?)";


//    private Integer id;
//    private String nombre;
//    private String apellido;
//    private String cedula;
//    private LocalDate fechaIngreso;
//    private Domicilio domicilio;

    @Override
    public Paciente guardar(Paciente paciente) {
        logger.info("Guardando paciente...");

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

        try{
            connection = BD.getConnection();
            Statement statement = connection.createStatement();
            PreparedStatement psSelectOne = connection.prepareStatement(SQL_SELECT_ONE);
            psSelectOne.setInt(1,id);
            ResultSet rs = psSelectOne.executeQuery();

            DomicilioDAOH2 domicilioDAOH2 = new DomicilioDAOH2();

            while(rs.next()){
                domicilio = domicilioDAOH2.buscarPorID(rs.getInt(6));
                paciente = new Paciente(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDate(5).toLocalDate(),domicilio);
            }

        }catch (Exception e){
            logger.warn(e.getMessage());
        }

        return paciente;
    }

    @Override
    public void eliminar(Integer id) {

    }

    @Override
    public void actualizar(Paciente paciente) {

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
                paciente = new Paciente(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),rs.getDate(5).toLocalDate(),domicilio );

                pacienteList.add(paciente);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return pacienteList;
    }
}
