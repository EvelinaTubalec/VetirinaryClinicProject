package com.leverx;

import com.leverx.model.Animal;
import com.leverx.model.Owner;
import com.leverx.repositories.imp.OwnerRepositoryImpl;
import com.leverx.services.OwnerService;

public class Main {
    public static void main(String[] args) {
        Owner owner = new Owner("Nick", "Morozov");
        Owner owner2 = new Owner("Vlad", "Liskov");
        OwnerService ownerService = new OwnerService();
        ownerService.saveOwner(owner);
        ownerService.saveOwner(owner2);

        ownerService.findAllOwners().stream().forEach(System.out::println);
    }
}
