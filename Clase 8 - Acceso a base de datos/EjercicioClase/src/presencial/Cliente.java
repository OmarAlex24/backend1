package presencial;

import org.apache.log4j.Logger;

import java.sql.*;

public class Cliente {
    private static final Logger logger = Logger.getLogger(Cliente.class);

    public static void main(String[] args) {
        Connection connection = null;

        try {
            connection = getConnection();

            //Nos va a permitir comunicarnos con la db
            Statement statement = connection.createStatement();

            // Crear la tabla, borrarla si ya existe
            statement.execute("DROP TABLE IF EXISTS ANIMALES; CREATE TABLE ANIMALES (ID INT PRIMARY KEY, NOMBRE VARCHAR(20) NOT NULL, TIPO VARCHAR(20) NOT NULL)");

            logger.info("Se creo correctamente la tabla en la bd");

            // Ahora insertamos a los animales
            statement.execute("INSERT INTO ANIMALES VALUES (1,'Angie','Delfin')," +
                                                                "(2,'Lucas','Rana')," +
                                                                "(3,'Saviolo','Conejo')," +
                                                                "(4,'Garfield','Gato')," +
                                                                "(5,'Oddy','Perro')");

            logger.info("Se insertaron correctamente los animales en la tabla ANIMALES");

            // Para mostrarlos necesito guardarlos en una clase ResultSet
            ResultSet rs = statement.executeQuery("SELECT * FROM ANIMALES");

            while (rs.next()){
                System.out.println("ID: "+rs.getInt(1)+
                                    " Nombre: "+rs.getString(2)+
                                    " Tipo: "+rs.getString(3));
            }
            System.out.println("------------------------------------------------");

            statement.execute("DELETE FROM ANIMALES WHERE ID=2");
            logger.warn("Se elimino el id 2");

            ResultSet rs1 = statement.executeQuery("SELECT * FROM ANIMALES");

            while (rs1.next()){
                System.out.println("ID: "+rs1.getInt(1)+
                        " Nombre: "+rs1.getString(2)+
                        " Tipo: "+rs1.getString(3));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
                logger.warn("Se cerro correctamente la conexion con la bd");
            }catch (SQLException e){
                e.getMessage();
            }
        }
    }

    public static Connection getConnection() throws Exception{
        //Estamos creando un metodo que devuelve la conexion
        // y nos carga el driver necesario

        Class.forName("org.h2.Driver");
        return DriverManager.getConnection("jdbc:h2:~/C3Animales","sa","sa");
    }
}
