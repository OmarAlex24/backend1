package dao;

public interface iDao <T>{
    T guardar (T t);

    T consultar(int id);

    T eliminar(int id);

    T modificar(int id);
}
