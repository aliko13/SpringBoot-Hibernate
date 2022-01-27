package com.example.springdata_hibernate.repository;

import com.example.springdata_hibernate.IntegrationTestHelper;
import com.example.springdata_hibernate.entity.component_mapping.Address;
import com.example.springdata_hibernate.entity.component_mapping.Employee;
import com.example.springdata_hibernate.repository.component_mapping.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.Instant;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

public class ComponentMappingTest extends IntegrationTestHelper {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    void thatEmployeeSaveWorks() {
        // given
        Address address = new Address();
        address.setCity("Hamburg");
        address.setHouseNo("12");
        address.setStreet("New Street");
        address.setCountry("Germany");
        address.setZipCode("1122");

        Employee employee = new Employee();
        employee.setDateOfBirth(Date.from(Instant.now()));
        employee.setName("Elon Musk");
        employee.setAddress(address);

        // when
        Employee savedEmployee = employeeRepository.save(employee);

        // then
        assertThat(savedEmployee)
                .extracting(Employee::getName, Employee::getDateOfBirth)
                .containsExactly(employee.getName(), employee.getDateOfBirth());
        assertThat(savedEmployee.getAddress())
                .extracting(Address::getCity, Address::getStreet, Address::getCountry, Address::getHouseNo)
                .containsExactly(address.getCity(), address.getStreet(), address.getCountry(), address.getHouseNo());
    }
}
