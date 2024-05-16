package dao;

import module.Domicilio;
import module.Paciente;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

public class PacienteDAOH2 implements iDao<Paciente> {
    public static final Logger logger = Logger.getLogger(PacienteDAOH2.class);

    private static final String SQL_SELECT_ONE = "SELECT * FROM PACIENTES WHERE ID = ?";

    @Override
    public Paciente guardar(Paciente paciente) {

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
    public List<Paciente> buscarTodos() {
        return List.of();
    }
}
