package com.leverx.services;

import com.leverx.model.Owner;
import com.leverx.model.Vet;
import com.leverx.repositories.imp.OwnerRepositoryImpl;

import java.util.List;

public class OwnerService {

    OwnerRepositoryImpl ownerRepository = new OwnerRepositoryImpl();

    public Owner findOwner(Long id) {
        return ownerRepository.findById(id);
    }

    public void saveOwner(Owner owner) {
        ownerRepository.create(owner);
    }

    public void deleteOwner(Long id) {
        ownerRepository.delete(id);
    }

    public void updateOwner(Owner owner) {
        ownerRepository.update(owner);
    }

    public List<Owner> findAllOwners() {
        return ownerRepository.findAll();
    }
}
