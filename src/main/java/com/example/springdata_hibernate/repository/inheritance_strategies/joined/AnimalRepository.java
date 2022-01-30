package com.example.springdata_hibernate.repository.inheritance_strategies.joined;

import com.example.springdata_hibernate.entity.inheritance_strategies.joined.Animal;
import org.springframework.data.repository.CrudRepository;

public interface AnimalRepository extends CrudRepository<Animal, Integer> { }
