package com.example.springdata_hibernate.entity.joined;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Animal {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;
    private String species;
    private String country;

    public int getId() { return id; }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
