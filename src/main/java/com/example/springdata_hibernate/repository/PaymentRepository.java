package com.example.springdata_hibernate.repository;

import com.example.springdata_hibernate.entity.Payment;
import org.springframework.data.repository.CrudRepository;

public interface PaymentRepository extends CrudRepository<Payment, Integer> { }
