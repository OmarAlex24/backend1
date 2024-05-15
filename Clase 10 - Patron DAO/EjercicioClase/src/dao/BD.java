package dao;

import org.apache.log4j.Logger;

import java.sql.*;


public class BD {
    private static final Logger logger = Logger.getLogger(BD.class);

    private static final String SQL_DROP_CREATE = "DROP TABLE IF EXISTS MEDICAMENTOS; "+
            "CREATE TABLE MEDICAMENTOS (ID INT PRIMARY KEY NOT NULL , CODIGO INT NOT NULL, NOMBRE VARCHAR(100) NOT NULL, LABORATORIO VARCHAR(100) NOT NULL, "+
            "CANTIDAD INT NOT NULL, PRECIO NUMERIC(10,2) NOT NULL)";


    public static void crearTabla(){
        Connection connection = null;

        try {
            connection = getConnection();
            Statement statement = connection.createStatement();
            statement.execute(SQL_DROP_CREATE);
            logger.info("Tabla creada con exito");

        } catch (Exception e) {
            logger.info(e.getMessage());
        }
    }

    public static Connection getConnection() throws Exception {
        Class.forName("org.h2.Driver");
        return DriverManager.getConnection("jdbc:h2:~/c10dao","sa","sa");
    }
}
