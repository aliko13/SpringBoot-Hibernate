package com.example.springdata_hibernate.repository.component_mapping;

import com.example.springdata_hibernate.entity.component_mapping.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> { }
