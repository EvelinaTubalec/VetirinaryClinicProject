package com.leverx.services;

import com.leverx.model.Vet;
import com.leverx.repositories.imp.VetRepositoryImpl;

import java.util.List;

public class VetService {

    VetRepositoryImpl vetRepository = new VetRepositoryImpl();

    public Vet findVet(Long id) {
        return vetRepository.findById(id);
    }

    public void saveVet(Vet vet) {
        vetRepository.create(vet);
    }

    public void deleteVet(Long id) {
        vetRepository.delete(id);
    }

    public void updateVet(Vet vet) {
        vetRepository.update(vet);
    }

    public List<Vet> findAllVets() {
        return vetRepository.findAll();
    }
}
