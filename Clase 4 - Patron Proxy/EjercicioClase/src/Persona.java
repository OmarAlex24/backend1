import java.util.Date;

public class Persona {
    private String nombreVacuna;
    private String nombre;
    private int cedula;
    private Date fechaVacunacion;

    public Persona(String nombreVacuna, String nombre, int cedula, Date fechaVacunacion) {
        this.nombreVacuna = nombreVacuna;
        this.nombre = nombre;
        this.cedula = cedula;
        this.fechaVacunacion = fechaVacunacion;
    }

    public void setNombreVacuna(String nombreVacuna) {
        this.nombreVacuna = nombreVacuna;
    }

    public String getNombreVacuna() {
        return nombreVacuna;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public void setFechaVacunacion(Date fechaVacunacion) {
        this.fechaVacunacion = fechaVacunacion;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCedula() {
        return cedula;
    }

    public Date getFechaVacunacion() {
        return fechaVacunacion;
    }
}
