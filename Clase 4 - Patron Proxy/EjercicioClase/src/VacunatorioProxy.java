import java.util.Date;

public class VacunatorioProxy implements VacunacionService{
    private Vacunatorio centroVacunatorio;

    public VacunatorioProxy() {
        centroVacunatorio = new Vacunatorio();
    }


    @Override
    public String vacunar(Persona persona) {
        Date hoy = new Date();
        System.out.println("La fecha de hoy es: "+hoy);

        if(hoy.before(persona.getFechaVacunacion())){
            return "Vuelva cuando sea su turno";
        }

        return centroVacunatorio.vacunar(persona);
    }
}
