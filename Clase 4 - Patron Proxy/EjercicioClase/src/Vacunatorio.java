public class Vacunatorio implements VacunacionService{

    @Override
    public String vacunar(Persona persona) {
        System.out.println("************* Verificando datos del paciente *************");
        System.out.println("Paciente vacunado satisfactoriamente");
        System.out.println("Datos del paciente:");
        System.out.println(persona.getCedula());
        System.out.println(persona.getNombre());
        System.out.println("Vacuna colocada : "+persona.getFechaVacunacion());

        return "";
    }
}
