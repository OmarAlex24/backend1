import dao.BD;
import module.Paciente;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import service.PacienteService;

public class PacienteServiceTest {
    @Test
    public void buscarPacientePorID(){
        BD.crearTabla();
        PacienteService pacienteService = new PacienteService();
        Integer id = 2;

        Paciente pacientePrueba = pacienteService.buscarPorID(id);
        Assertions.assertTrue(pacientePrueba != null);

        pacientePrueba = pacienteService.buscarPorID(3);
        Assertions.assertTrue(pacientePrueba == null);
    }
}
