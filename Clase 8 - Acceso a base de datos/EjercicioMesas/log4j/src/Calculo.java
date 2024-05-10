import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class Calculo {
    private Double promedio;
    private Double maximo;
    private Double minimo;

    List<Integer> listaNumeros;
    Logger logger = Logger.getLogger(Calculo.class);

    public Calculo(List<Integer> listaNumeros) {
        this.listaNumeros = listaNumeros;

        if (listaNumeros.size() > 10) {
            logger.info("La longitud de la lista es mayor a 10");
        } else if(listaNumeros.size() > 5){
            logger.info("La longitud de la lista es mayor a 5");
        } else if (listaNumeros.isEmpty()) {
            logger.error("La lista es igual a cero");
        }
    }

    public Double calcularPromedio(){

        try{
            if(listaNumeros.isEmpty()){
                logger.error("La lista es igual a cero");
                throw new Exception("No se puede sacar el promedio de una lista vacia");
            }
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }


        Double acumulador = 0.0;

        for (Integer numero: listaNumeros) {
            acumulador+=numero;
        }

        return acumulador / listaNumeros.size();
    }

    public Integer encontrarMaximo(){

        try{
            if(listaNumeros.isEmpty()){
                logger.error("La lista es igual a cero");
                throw new Exception("No se puede sacar el maximo de una lista vacia");
            }
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }

        int maximo = 0;

        for (Integer numero: listaNumeros) {
           if(maximo < numero){
               maximo = numero;
           }
        }
        return maximo;
    }

    public Integer encontrarMinimo(){

        try{
            if(listaNumeros.isEmpty()){
                logger.error("La lista es igual a cero");
                throw new Exception("No se puede sacar el minimo de una lista vacia");
            }
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }

        int minimo = listaNumeros.get(0);

        for (Integer numero: listaNumeros) {
            if(minimo > numero){
                minimo = numero;
            }
        }
        return minimo;
    }
}
