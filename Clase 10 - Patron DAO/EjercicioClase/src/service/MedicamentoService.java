package service;

import dao.MedicamentoDAOH2;
import dao.iDao;
import model.Medicamento;

public class MedicamentoService {
    private iDao<Medicamento> medicamentoiDao;

    public MedicamentoService() {
        medicamentoiDao = new MedicamentoDAOH2();
    }

    public Medicamento guardarMedicamento(Medicamento medicamento){
        return medicamentoiDao.guardar(medicamento);
    }

    public Medicamento consultarMedicamento(Integer id){
        return medicamentoiDao.consultar(id);
    }
}
