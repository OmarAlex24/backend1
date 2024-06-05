package com.omar.tablamovimientos.controller;

import com.omar.tablamovimientos.entity.Movimiento;
import com.omar.tablamovimientos.service.MovimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/movimientos")
public class MovimientoController {
    @Autowired
    private MovimientoService movimientoService;

    @PostMapping
    public ResponseEntity<Movimiento> guardarMovimiento(@RequestBody Movimiento movimiento){
        return ResponseEntity.ok(movimientoService.guardarMovimiento(movimiento));
    }

    @GetMapping
    public ResponseEntity<List<Movimiento>> listarMovimientos(){
        return ResponseEntity.ok(movimientoService.listarMovimientos());
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> actualizarMovimiento(@PathVariable Long id, @RequestBody Movimiento movimiento){
        Optional<Movimiento> movimientoBuscado = movimientoService.buscarMovimientoPorId(id);

        if(movimientoBuscado.isEmpty()){
            return ResponseEntity.badRequest().body("Movimiento no encontrado");
        }

        movimientoService.actualizarMovimiento(movimiento);
        return ResponseEntity.ok("Movimiento actualizado con exito");
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Movimiento>> buscarMovimientoPorId(@PathVariable Long id){
        return ResponseEntity.ok(movimientoService.buscarMovimientoPorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarMovimientoPorId(@PathVariable Long id){
        Optional<Movimiento> movimientoBuscado = movimientoService.buscarMovimientoPorId(id);

        if(movimientoBuscado.isEmpty()){
            return ResponseEntity.badRequest().body("Movimiento no encontrado");
        }

        movimientoService.eliminarMovimientoPorId(id);
        return ResponseEntity.ok("Movimiento actualizado con exito");
    }
}
