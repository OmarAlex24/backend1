package dao;

import org.apache.log4j.Logger;

import java.sql.*;

public class BD {
    private static final Logger logger = Logger.getLogger(BD.class);

    public static final String SQL_DROP_CREATE = "DROP TABLE IF EXISTS Nombre; "+
            "CREATE TABLE Nombre (ID INT PRIMARY KEY NOT NULL)";
    //Modificar columnas de la tabla

    public static void crearTabla(){
        Connection connection = null;

        try{
            connection = getConnection();
            Statement statement = connection.createStatement();

            statement.execute(SQL_DROP_CREATE);
            logger.info("Tabla creada con exito");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static Connection getConnection() throws Exception{
        Class.forName("org.h2.Driver");
        return DriverManager.getConnection("jdbc:h2:~/Examen","sa","sa");
    }
}
