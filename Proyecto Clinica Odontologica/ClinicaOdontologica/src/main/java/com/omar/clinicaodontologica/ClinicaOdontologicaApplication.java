package com.omar.clinicaodontologica;

import com.omar.clinicaodontologica.dao.BD;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ClinicaOdontologicaApplication {

    public static void main(String[] args) {
        BD.crearTabla();
        SpringApplication.run(ClinicaOdontologicaApplication.class, args);
    }

}
