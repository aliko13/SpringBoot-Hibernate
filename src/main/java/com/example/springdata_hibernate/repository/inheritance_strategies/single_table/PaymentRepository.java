package com.example.springdata_hibernate.repository.inheritance_strategies.single_table;

import com.example.springdata_hibernate.entity.inheritance_strategies.single_table.Payment;
import org.springframework.data.repository.CrudRepository;

public interface PaymentRepository extends CrudRepository<Payment, Integer> { }
