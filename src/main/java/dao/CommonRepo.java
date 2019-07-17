package dao;

import java.util.List;

public interface CommonRepo<T> {

    List<T> getAll();
    void add(T type);
    void delete(Long id);
    T getById(Long id);
    void update(T type);

}
