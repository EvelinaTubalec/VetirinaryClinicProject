package com.leverx.repositories;

import java.util.List;

public interface CrudOperations<T> {

    List<T> findAll();

    T create(T entity);

    T update(T entity);

    void delete(Long d);
}
