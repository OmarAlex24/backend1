package dao;

import module.Domicilio;
import module.Paciente;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

public class DomicilioDAOH2 implements iDao<Domicilio> {
    public static final Logger logger = Logger.getLogger(DomicilioDAOH2.class);

    private static final String SQL_SELECT_ONE = "SELECT * FROM DOMICILIOS WHERE ID = ?";

    @Override
    public Domicilio guardar(Domicilio domicilio) {
        return null;
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

        return domicilio;
    }

    @Override
    public void eliminar(Integer id) {

    }

    @Override
    public void actualizar(Domicilio domicilio) {

    }

    @Override
    public List<Domicilio> buscarTodos() {
        return List.of();
    }
}
