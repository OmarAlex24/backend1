import org.apache.log4j.Logger;
import java.sql.*;

public class Cliente {

    private static final String SQL_DROP_CREATE="DROP TABLE IF EXISTS ODONTOLOGOS; " +
            "CREATE TABLE ODONTOLOGOS (ID INT PRIMARY KEY, NOMBRE VARCHAR(100) NOT NULL, APELLIDO VARCHAR(100) NOT NULL, MATRICULA VARCHAR(50) NOT NULL)";

    private static final String SQL_INSERT="INSERT INTO ODONTOLOGOS VALUES(?,?,?,?)";
    private static final String SQL_UPDATE="UPDATE ODONTOLOGOS SET MATRICULA=? WHERE ID=?";
    private static final Logger logger= Logger.getLogger(Cliente.class);

    public static void main(String[] args) {
        Connection connection = null;

        try {
            connection = getConnection();

            Statement statement = connection.createStatement();
            statement.execute(SQL_DROP_CREATE);
            logger.info("Tabla creada con exito");

            PreparedStatement psInsert = connection.prepareStatement(SQL_INSERT);
            psInsert.setInt(1,1);
            psInsert.setString(2, "Julio");
            psInsert.setString(3, "Perez");
            psInsert.setString(4, "123456");
            psInsert.execute();
            logger.info("Datos insertados con exito");

            ResultSet rs = statement.executeQuery("SELECT * FROM ODONTOLOGOS");
            rs.next();
            System.out.println("Matricula: " + rs.getString(4));

            // <------ Actualizamos ------>
            connection.setAutoCommit(false);

            PreparedStatement psUpdate = connection.prepareStatement(SQL_UPDATE);
            psUpdate.setString(1,"654321");
            psUpdate.setInt(2,1);
            psUpdate.execute();

            connection.commit();
            connection.setAutoCommit(true);


            ResultSet rs1 = statement.executeQuery("SELECT * FROM ODONTOLOGOS");
            rs1.next();
            System.out.println("Matricula: " + rs1.getString(4));


        } catch (Exception e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            logger.warn(e.getMessage());
        }
    }


    public static Connection getConnection() throws Exception{
        Class.forName("org.h2.Driver");
        return DriverManager.getConnection("jdbc:h2:~/C9_Consultas","sa","sa");
    }
}
