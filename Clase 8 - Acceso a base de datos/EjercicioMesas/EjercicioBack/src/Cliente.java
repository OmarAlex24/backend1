import org.apache.log4j.Logger;

import java.sql.*;

public class Cliente {
    private static final Logger logger = Logger.getLogger(Cliente.class);

    public static void main(String[] args) {
        Connection conexion = null;

        try{
            conexion = getConnection();

            //Nos va a permitir comunicarnos con la db
            Statement statement = conexion.createStatement();

            statement.execute("DROP TABLE IF EXISTS FIGURAS; CREATE TABLE FIGURAS(ID INT PRIMARY KEY NOT NULL , FIGURA VARCHAR(15) NOT NULL, COLOR VARCHAR(15) NOT NULL)");
            logger.info("La tabla se creo correctamente");

            statement.execute("INSERT INTO FIGURAS VALUES (1,'Circulo','Rojo'), (2,'Circulo','Amarillo'), (3,'Cuadrado','Amarillo'), (4,'Cuadrado','Rojo'), (5,'Cuadrado','Azul')");
            logger.info("Se insertaron los datos a la tabla correctamente");

            ResultSet rs = statement.executeQuery("SELECT * FROM FIGURAS");

            System.out.println("-------------------------------------------------------------");

            while(rs.next()){
                System.out.println("ID: "+rs.getInt(1)+ " Figura: "+rs.getString(2)+ " Color: "+rs.getString(3));
            }
            System.out.println("-------------------------------------------------------------");

            ResultSet rsColorRojo = statement.executeQuery("SELECT * FROM FIGURAS WHERE COLOR = 'Rojo' AND FIGURA = 'Circulo'");

            while(rsColorRojo.next()){
                System.out.println("ID: "+rsColorRojo.getInt(1)+ " Figura: "+rsColorRojo.getString(2)+ " Color: "+rsColorRojo.getString(3));
            }
            System.out.println("-------------------------------------------------------------");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try{
                conexion.close();
                logger.warn("Se cerro correctamente la conexion a la bd");
            } catch (SQLException e) {
                e.getMessage();
            }
        }
    }

    public static Connection getConnection() throws Exception{
        //Creación de método que nos devuelve la conexión y nos carga el driver necesario.
        Class.forName("org.h2.Driver");
        return DriverManager.getConnection("jdbc:h2:~/C3Figuras","user123","user123");
    }
}