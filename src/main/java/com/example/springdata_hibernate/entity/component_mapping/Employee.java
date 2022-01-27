package com.example.springdata_hibernate.entity.component_mapping;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Employee {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;
    private String name;
    @Column(name = "date_of_birth")
    private Date dateOfBirth;
    @Embedded
    private Address address;
}
