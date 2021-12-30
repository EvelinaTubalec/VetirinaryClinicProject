package com.leverx.services;

import com.leverx.model.Animal;
import com.leverx.model.Vet;
import com.leverx.repositories.imp.AnimalRepositoryImpl;
import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.jboss.logging.Logger;

import java.util.List;

public class AnimalService {

    private final AnimalRepositoryImpl animalRepository = new AnimalRepositoryImpl();
    private static final Logger log = LoggerFactory.logger(AnimalService.class);

    public Animal findAnimal(Long id) {
        log.debug("Find animal by id " + id);
        return animalRepository.findById(id);
    }

    public void saveAnimal(Animal animal) {
        log.debug("Save animal");
        animalRepository.create(animal);
    }

    public void deleteAnimal(Long id) {
        log.debug("Delete animal by id " + id);
        animalRepository.delete(id);
    }

    public void updateAnimal(Animal animal) {
        log.debug("Update animal");
        animalRepository.update(animal);
    }

    public List<Animal> findAllAnimals() {
        log.debug("Find animals");
        return animalRepository.findAll();
    }
}
