package model.dao.daoInterfaces;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

/**
 * DAO interface with basic operations
 * @param <T>
 * @param <PK>
 */
public interface Dao<T, PK extends Serializable> {

    PK add(T t);

    T find(PK id);

    void update(T t);

    void delete(PK id);

    List<T> findAll();
}
