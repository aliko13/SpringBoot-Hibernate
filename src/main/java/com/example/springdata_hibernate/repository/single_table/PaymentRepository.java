package com.example.springdata_hibernate.repository.single_table;

import com.example.springdata_hibernate.entity.single_table.Payment;
import org.springframework.data.repository.CrudRepository;

public interface PaymentRepository extends CrudRepository<Payment, Integer> { }
