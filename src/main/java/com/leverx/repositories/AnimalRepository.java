package com.leverx.repositories;

import com.leverx.model.Animal;

import java.util.List;

public class AnimalRepository implements  CrudOperations<Animal>{

    @Override
    public List<Animal> findAll() {
        return null;
    }

    @Override
    public Animal create(Animal entity) {
        return null;
    }

    @Override
    public Animal update(Animal entity) {
        return null;
    }

    @Override
    public void delete(Long d) {

    }
}
