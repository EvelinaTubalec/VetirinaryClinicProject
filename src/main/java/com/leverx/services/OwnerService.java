package com.leverx.services;

import com.leverx.model.Owner;
import com.leverx.repositories.imp.OwnerRepositoryImpl;
import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.jboss.logging.Logger;

import java.util.List;

public class OwnerService {

    private final OwnerRepositoryImpl ownerRepository = new OwnerRepositoryImpl();
    private static final Logger log = LoggerFactory.logger(OwnerService.class);

    public Owner findOwner(Long id) {
        log.debug("Find owner by id " + id);
        return ownerRepository.findById(id);
    }

    public void saveOwner(Owner owner) {
        log.debug("Save owner");
        ownerRepository.create(owner);
    }

    public void deleteOwner(Long id) {
        log.debug("Delete owner by id " + id);
        ownerRepository.delete(id);
    }

    public void updateOwner(Owner owner) {
        log.debug("Update owner");
        ownerRepository.update(owner);
    }

    public List<Owner> findOwners() {
        log.debug("Find owners");
        return ownerRepository.findAll();
    }
}
