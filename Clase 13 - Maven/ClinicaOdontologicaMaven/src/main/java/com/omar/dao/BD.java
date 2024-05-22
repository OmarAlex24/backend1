package com.omar.dao;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class BD {

    public static final Logger logger = Logger.getLogger(BD.class);
    public static final String SQL_CREATE_PACIENTE = "DROP TABLE IF EXISTS PACIENTES; "+
            "CREATE TABLE PACIENTES (ID INT AUTO_INCREMENT PRIMARY KEY, NOMBRE VARCHAR(100) NOT NULL, APELLIDO VARCHAR(100) NOT NULL, "+
            "CEDULA VARCHAR(100) NOT NULL, FECHA_INGRESO DATE NOT NULL, DOMICILIO_ID INT NOT NULL)";

    public static final String SQL_CREATE_DOMICILIO = "DROP TABLE IF EXISTS DOMICILIO; "+
            "CREATE TABLE DOMICILIOS (ID INT AUTO_INCREMENT PRIMARY KEY, CALLE VARCHAR(100) NOT NULL, NUMERO INT NOT NULL, "+
            "LOCALIDAD VARCHAR(100) NOT NULL, PROVINCIA VARCHAR(100) NOT NULL)";

    public static final String SQL_CREATE_ODONTOLOGO= "DROP TABLE IF EXISTS ODONTOLOGOS; "+
            "CREATE TABLE ODONTOLOGOS (MATRICULA INT PRIMARY KEY NOT NULL, NOMBRE VARCHAR(100) NOT NULL, APELLIDO VARCHAR(100) NOT NULL)";

    private static final String SQL_PRUEBA = "INSERT INTO PACIENTES (NOMBRE, APELLIDO, CEDULA, FECHA_INGRESO, DOMICILIO_ID) VALUES ('Jorgito','Pererya','111111','2024-05-16', 1),('Omar','Espinosa','22222','2024-01-16',2); "+
            "INSERT INTO DOMICILIOS (CALLE, NUMERO, LOCALIDAD, PROVINCIA) VALUES ('Siempre viva',543,'Springfield','USA'),('Av. Uruguay',111,'Veracruz','Mexico')";

    public static void crearTabla(){
        Connection connection = null;

        try{
            connection = getConnection();
            Statement statement = connection.createStatement();
            statement.execute(SQL_CREATE_PACIENTE);
            statement.execute(SQL_CREATE_DOMICILIO);
            statement.execute(SQL_CREATE_ODONTOLOGO);
            statement.execute(SQL_PRUEBA);

            logger.info("Tabla creada con exito!");

        } catch (Exception e) {
            logger.warn(e.getMessage());
        }
    }

    public static Connection getConnection() throws Exception{
        Class.forName("org.h2.Driver");
        return DriverManager.getConnection("jdbc:h2:mem:~/C10Clinica","sa", "sa");
    }
}
