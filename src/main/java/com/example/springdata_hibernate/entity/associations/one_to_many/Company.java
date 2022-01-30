package com.example.springdata_hibernate.entity.associations.one_to_many;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private int id;
    private String name;
    private String email;
    @OneToMany(mappedBy = "company")
    private Set<PhoneNumber> phoneNumberList = Set.of();

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<PhoneNumber> getPhoneNumberList() {
        return phoneNumberList;
    }

    public void setPhoneNumberList(Set<PhoneNumber> phoneNumberList) {
        this.phoneNumberList = phoneNumberList;
    }
}
