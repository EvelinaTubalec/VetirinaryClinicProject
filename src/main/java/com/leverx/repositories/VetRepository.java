package com.leverx.repositories;


import com.leverx.model.Vet;

public interface VetRepository extends  CrudOperations<Vet>{

    Vet findByLogin(String login);
}
