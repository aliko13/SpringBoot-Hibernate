package com.example.springdata_hibernate.entity.component_mapping;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Address {
    private String street;
    @Column(name = "house_no")
    private String houseNo;
    private String city;
    @Column(name = "zip_code")
    private String zipCode;
    private String country;
}
