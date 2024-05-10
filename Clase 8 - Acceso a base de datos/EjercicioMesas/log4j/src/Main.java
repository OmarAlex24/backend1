import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

            List<Integer> listaVacia = Arrays.asList();
            List<Integer> lista1 = Arrays.asList(1, 2, 3, 4, 5, 6);
            List<Integer> lista2 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11);

            Calculo calculo = new Calculo(listaVacia);
            Calculo calculo1 = new Calculo(lista1);
            Calculo calculo2 = new Calculo(lista2);

            System.out.println("Promedio: " + calculo.calcularPromedio());
            System.out.println("Promedio: " + calculo1.calcularPromedio());
            System.out.println("Promedio: " + calculo2.calcularPromedio());
            System.out.println("----------------------------------------------");
            System.out.println("Maximo: " + calculo.encontrarMaximo());
            System.out.println("Maximo: " + calculo1.encontrarMaximo());
            System.out.println("Maximo: " + calculo2.encontrarMaximo());
            System.out.println("----------------------------------------------");
            System.out.println("Minimo: " + calculo.encontrarMinimo());
            System.out.println("Minimo: " + calculo1.encontrarMinimo());
            System.out.println("Minimo: " + calculo2.encontrarMinimo());

    }
}
