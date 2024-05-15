import dao.BD;
import model.Medicamento;
import org.apache.log4j.Logger;
import service.MedicamentoService;

public class Cliente {
    private static final Logger logger = Logger.getLogger(Cliente.class);
    public static void main(String[] args) {
        Medicamento medicamento = new Medicamento(1,123, "Paracetamol", "Pfizer", 100,24.5);

        BD.crearTabla();

        MedicamentoService medicamentoService = new MedicamentoService();
        medicamentoService.guardarMedicamento(medicamento);

        Medicamento prueba = medicamentoService.consultarMedicamento(1);
        Medicamento prueba1 = medicamentoService.consultarMedicamento(2);

        if(prueba != null){
            logger.info("Medicamento encontrado: "+prueba.getNombre());
        } else{
            logger.warn("Medicamento no encontrado");
        }

        if(prueba1 != null){
            logger.info("Medicamento encontrado: "+prueba1.getNombre());
        } else{
            logger.warn("Medicamento no encontrado");
        }
    }
}
