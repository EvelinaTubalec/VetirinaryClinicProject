package com.leverx.services;

import com.leverx.model.Animal;
import com.leverx.model.Vet;
import com.leverx.repositories.imp.AnimalRepositoryImpl;

import java.util.List;

public class AnimalService {

    AnimalRepositoryImpl animalRepository = new AnimalRepositoryImpl();

    public Animal findAnimal(Long id) {
        return animalRepository.findById(id);
    }

    public void saveAnimal(Animal animal) {
        animalRepository.create(animal);
    }

    public void deleteAnimal(Long id) {
        animalRepository.delete(id);
    }

    public void updateAnimal(Animal animal) {
        animalRepository.update(animal);
    }

    public List<Animal> findAllAnimals() {
        return animalRepository.findAll();
    }
}
