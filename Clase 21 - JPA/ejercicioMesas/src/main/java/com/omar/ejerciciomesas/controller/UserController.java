package com.omar.ejerciciomesas.controller;

import com.omar.ejerciciomesas.entity.User;
import com.omar.ejerciciomesas.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<User> crearUsuario(@RequestBody User user){
        return ResponseEntity.ok(userService.guardarUsuario(user));
    }

    @GetMapping
    public ResponseEntity<List<User>> listarUsuarios(){
        return ResponseEntity.ok(userService.listarUsuarios());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<User>> obtenerUsuarioPorId(@PathVariable Long id){
        Optional<User> userBuscado = userService.mostrarUsuarioPorId(id);

        if(userBuscado.isEmpty()){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(userBuscado);
    }

    @PutMapping()
    public ResponseEntity<String> modificarUsuario(@RequestBody User user){
        Optional<User> userBuscado = userService.mostrarUsuarioPorId(user.getId());

        if(userBuscado.isEmpty()){
            return ResponseEntity.badRequest().body("Usuario no encontrado");
        }
        userService.modificarUsuario(user);
        return ResponseEntity.ok("Usuario modificado");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarUsuario(@PathVariable Long id){
        Optional<User> userBuscado = userService.mostrarUsuarioPorId(id);

        if(userBuscado.isEmpty()){
            return ResponseEntity.badRequest().body("Usuario no encontrado");
        }
        userService.eliminarUsuarioPorId(userBuscado.get().getId());
        return ResponseEntity.ok("Usuario eliminado");
    }
}
