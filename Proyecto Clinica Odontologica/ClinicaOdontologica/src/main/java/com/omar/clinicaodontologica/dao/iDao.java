package com.omar.clinicaodontologica.dao;

import java.util.List;

public interface iDao <T>{
    T guardar(T t);

    T buscarPorID(Integer id);

    void eliminar(Integer id);

    void actualizar(T t);

    List<T> listarTodos();

    T buscarPorString(String string);

}
