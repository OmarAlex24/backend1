package com.omar.tablamovimientos.service;

import com.omar.tablamovimientos.entity.Movimiento;
import com.omar.tablamovimientos.repository.MovimientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovimientoService {
    @Autowired
    private MovimientoRepository movimientoRepository;

    public Movimiento guardarMovimiento(Movimiento movimiento){
        return movimientoRepository.save(movimiento);
    }

    public List<Movimiento> listarMovimientos(){
        return movimientoRepository.findAll();
    }

    public void actualizarMovimiento(Movimiento movimiento){
        movimientoRepository.save(movimiento);
    }

    public Optional<Movimiento> buscarMovimientoPorId(Long id){
        return movimientoRepository.findById(id);
    }

    public void eliminarMovimientoPorId(Long id){
        movimientoRepository.deleteById(id);
    }
}
