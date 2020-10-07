package com.practice.petclinic.bootstrap;

import com.practice.petclinic.model.Owner;
import com.practice.petclinic.model.PetType;
import com.practice.petclinic.model.Vet;
import com.practice.petclinic.services.OwnerService;
import com.practice.petclinic.services.PetTypeService;
import com.practice.petclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Owner owner1 = new Owner();
        owner1.setFirstName("Mike");
        owner1.setLastName("West");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Dave");
        owner2.setLastName("Tee");

        ownerService.save(owner2);

        System.out.println("Loaded Owners...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Connor");
        vet1.setLastName("McG");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Alice");
        vet2.setLastName("Porter");

        vetService.save(vet2);

        System.out.println("Loaded Vets...");
    }
}
