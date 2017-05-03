package main.models.dao;

import java.util.Collection;

/**
 * Created by admin on 22.04.2017. 12
 */
public interface DAO<PK, E> {

    Collection<E> getAll();

    E getByID(PK id);

    PK insert(E entity);

    void update(E entity);

    void delete(E entity);
}
