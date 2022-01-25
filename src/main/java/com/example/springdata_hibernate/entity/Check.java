package com.example.springdata_hibernate.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "ch")
public class Check extends Payment {

    @Column(name = "check_number")
    private String checkNumber;

    public void setCheckNumber(String number) {
        this.checkNumber = number;
    }

    public String getCheckNumber() {
        return checkNumber;
    }
}
