package com.example.springdata_hibernate.repository;

import com.example.springdata_hibernate.IntegrationTestHelper;
import com.example.springdata_hibernate.entity.inheritance_strategies.joined.Animal;
import com.example.springdata_hibernate.entity.inheritance_strategies.joined.Pet;
import com.example.springdata_hibernate.entity.inheritance_strategies.joined.Wild;
import com.example.springdata_hibernate.repository.inheritance_strategies.joined.AnimalRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.Instant;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

public class JoinedInheritanceTest extends IntegrationTestHelper {

    @Autowired
    private AnimalRepository animalRepository;

    @Test
    void thatSavePetWorks() {
        // given
        Pet pet = new Pet();
        pet.setName("Alex");
        pet.setBirthday(Date.from(Instant.now()));
        pet.setSpecies("german sheppard");
        pet.setCountry("Germany");

        // when
        Pet savedPet = animalRepository.save(pet);
        Animal animal = animalRepository.findById(savedPet.getId()).orElseThrow();

        // then
        assertThat(savedPet)
                .extracting(Pet::getName, Pet::getBirthday, Pet::getCountry, Pet::getSpecies)
                .containsExactly(pet.getName(), pet.getBirthday(), pet.getCountry(), pet.getSpecies());
        assertThat(animal)
                .extracting(Animal::getId, Animal::getCountry, Animal::getSpecies)
                .containsExactly(pet.getId(), pet.getCountry(), pet.getSpecies());
    }

    @Test
    void thatSetWildWorks() {
        // given
        Wild wild = new Wild();
        wild.setName("House");
        wild.setBirthday(Date.from(Instant.now()));
        wild.setSpecies("lion");
        wild.setCountry("Africa");

        // when
        Wild savedWild = animalRepository.save(wild);
        Animal animal = animalRepository.findById(savedWild.getId()).orElseThrow();

        // then
        assertThat(savedWild)
                .extracting(Wild::getName, Wild::getBirthday, Wild::getCountry, Wild::getSpecies)
                .containsExactly(wild.getName(), wild.getBirthday(), wild.getCountry(), wild.getSpecies());
        assertThat(animal)
                .extracting(Animal::getId, Animal::getCountry, Animal::getSpecies)
                .containsExactly(wild.getId(), wild.getCountry(), wild.getSpecies());
    }
}
