package dao;

public interface iDao<T> {
    T guardar (T t);

    T consultar(Integer id);
}
