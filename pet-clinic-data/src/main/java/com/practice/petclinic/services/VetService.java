package com.practice.petclinic.services;

import com.practice.petclinic.model.Vet;

import java.util.Set;

public interface VetService {

    Vet findByID(Long id);

    Vet save(Vet vet);

    Set<Vet> findAll();
}
