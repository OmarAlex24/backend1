package presencial;

public class Persona {
    private String nombre;
    private int edad;

    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public boolean esMayorEdad(){
        return edad >= 18;
    }

    public boolean edadValida(){
        return edad >= 0 && edad <= 120;
    }
    public boolean longitudNombreValido(){
        return nombre.length() > 4;
    }

    public boolean nombreEsNumero(){
        char []nombreCharArr = nombre.toCharArray();

        for(char caracter : nombreCharArr){
            if(!Character.isLetter(caracter)){
                return true;
            }
        }
        return false;
    }

    public boolean esPersonaValida(){
        return esMayorEdad() && edadValida() && longitudNombreValido() && !nombreEsNumero();
    }
}
