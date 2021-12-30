package com.leverx.services;

import com.leverx.model.Vet;
import com.leverx.repositories.imp.VetRepositoryImpl;
import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.jboss.logging.Logger;

import java.util.List;

public class VetService {

    private final VetRepositoryImpl vetRepository = new VetRepositoryImpl();
    private static final Logger log = LoggerFactory.logger(VetService.class);

    public Vet findVet(Long id) {
        log.debug("Find vet by id " + id);
        return vetRepository.findById(id);
    }

    public void saveVet(Vet vet) {
        log.debug("Save vet");
        vetRepository.create(vet);
    }

    public void deleteVet(Long id) {
        log.debug("Delete vet by id " + id);
        vetRepository.delete(id);
    }

    public void updateVet(Vet vet) {
        log.debug("Update vet");
        vetRepository.update(vet);
    }

    public List<Vet> findAllVets() {
        log.debug("Find notes");
        return vetRepository.findAll();
    }
}
