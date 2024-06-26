package dao;

import java.util.List;

public interface iDao <T>{
    T guardar(T t);

    T buscarPorID(Integer id);

    void eliminar(Integer id);

    void actualizar(T t);

    List<T> buscarTodos();
}
