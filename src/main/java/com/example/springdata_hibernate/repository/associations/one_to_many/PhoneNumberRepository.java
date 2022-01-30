package com.example.springdata_hibernate.repository.associations.one_to_many;

import com.example.springdata_hibernate.entity.associations.one_to_many.PhoneNumber;
import org.springframework.data.repository.CrudRepository;

public interface PhoneNumberRepository extends CrudRepository<PhoneNumber, Integer> { }
