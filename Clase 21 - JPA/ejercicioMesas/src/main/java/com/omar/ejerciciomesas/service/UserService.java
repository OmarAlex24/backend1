package com.omar.ejerciciomesas.service;

import com.omar.ejerciciomesas.entity.User;
import com.omar.ejerciciomesas.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User guardarUsuario(User user){
        return userRepository.save(user);
    }

    public Optional<User> mostrarUsuarioPorId(Long id){
        return userRepository.findById(id);
    }

    public List<User> listarUsuarios(){
        return userRepository.findAll();
    }

    public void modificarUsuario(User user){
        userRepository.save(user);
    }

    public void eliminarUsuarioPorId(Long id){
        userRepository.deleteById(id);
    }
}
