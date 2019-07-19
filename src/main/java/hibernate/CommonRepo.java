package hibernate;

import java.util.List;

public interface CommonRepo<T> {

    T getById(Long id);
    List<T> getAll();
    void add(T type);
    void delete(T type);
    void update(T type);

}
