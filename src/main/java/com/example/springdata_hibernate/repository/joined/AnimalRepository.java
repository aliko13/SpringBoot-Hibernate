package com.example.springdata_hibernate.repository.joined;

import com.example.springdata_hibernate.entity.joined.Animal;
import org.springframework.data.repository.CrudRepository;

public interface AnimalRepository extends CrudRepository<Animal, Integer> { }
