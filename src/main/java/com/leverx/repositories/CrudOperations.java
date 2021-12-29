package com.leverx.repositories;

import java.util.List;

public interface CrudOperations<T> {

    T findById(Long id);

    List<T> findAll();

    void create(T entity);

    void update(T entity);

    void delete(Long id);
}
