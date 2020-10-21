package com.practice.petclinic.bootstrap;

import com.practice.petclinic.model.*;
import com.practice.petclinic.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtiesService specialtiesService;
    private final VisitService visitService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService,
                      SpecialtiesService specialtiesService, VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtiesService = specialtiesService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception {

        int count = petTypeService.findAll().size();

        if (count == 0) {
            loadData();
        }
    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Speciality radiology = new Speciality();
        radiology.setDescription("radiology");
        Speciality savedRadio = specialtiesService.save(radiology);

        Speciality surgery = new Speciality();
        surgery.setDescription("surgery");
        Speciality savedSurgery = specialtiesService.save(surgery);

        Speciality dentistry = new Speciality();
        dentistry.setDescription("dentistry");
        Speciality savedDentistry = specialtiesService.save(dentistry);

        Owner owner1 = new Owner();
        owner1.setFirstName("Mike");
        owner1.setLastName("West");
        owner1.setAddress("123 smithway");
        owner1.setCity("London");
        owner1.setTelephone("09182411412");

        Pet mikesPet = new Pet();
        mikesPet.setPetType(savedDogPetType);
        mikesPet.setOwner(owner1);
        mikesPet.setBirthDate(LocalDate.now());
        mikesPet.setName("Rosco");

        owner1.getPets().add(mikesPet);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Dave");
        owner2.setLastName("Tee");
        owner2.setAddress("123 smithway");
        owner2.setCity("London");
        owner2.setTelephone("09182411412");

        Pet davesPet = new Pet();
        davesPet.setPetType(savedCatPetType);
        davesPet.setOwner(owner2);
        davesPet.setBirthDate(LocalDate.now());
        davesPet.setName("Saff");

        owner2.getPets().add(davesPet);

        ownerService.save(owner2);

        Visit catVisit = new Visit();
        catVisit.setPet(davesPet);
        catVisit.setDate(LocalDate.now());
        catVisit.setDescription("got a cold");

        visitService.save(catVisit);

        System.out.println("Loaded Owners...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Connor");
        vet1.setLastName("McG");
        vet1.getSpecialities().add(savedRadio);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Alice");
        vet2.setLastName("Porter");
        vet2.getSpecialities().add(savedSurgery);

        vetService.save(vet2);

        System.out.println("Loaded Vets...");
    }
}
