package com.example.springdata_hibernate.repository;

import com.example.springdata_hibernate.IntegrationTestHelper;
import com.example.springdata_hibernate.entity.associations.one_to_many.Company;
import com.example.springdata_hibernate.entity.associations.one_to_many.PhoneNumber;
import com.example.springdata_hibernate.entity.associations.one_to_many.PhoneNumberType;
import com.example.springdata_hibernate.repository.associations.one_to_many.CompanyRepository;
import com.example.springdata_hibernate.repository.associations.one_to_many.PhoneNumberRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class OneToManyAssociationsTest extends IntegrationTestHelper {
    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private PhoneNumberRepository phoneNumberRepository;

    private final Company company = new Company();
    private final PhoneNumber phoneNumber = new PhoneNumber();

    @BeforeEach
    void setUp() {
        // initialize company
        company.setName("Company GmbH");
        company.setEmail("company@gmail.com");

        // initialize phone_number
        phoneNumber.setNumber("1223456");
        phoneNumber.setPhoneNumberType(PhoneNumberType.LAND_LINE);
    }

    @Test
    void thatSaveAndFetchWithoutPhoneNumbersWorks() {
        // when
        Company savedCompany = companyRepository.save(company);

        // then
        assertThat(savedCompany)
                .extracting(Company::getName, Company::getEmail)
                .containsExactly(company.getName(), company.getEmail());
    }

    @Test
    void thatSaveAndFetchWithPhoneNumbersWorks() {
        // given
        phoneNumber.setCompany(company);
        company.setPhoneNumberList(Set.of(phoneNumber));

        // when
        Company savedCompany = companyRepository.save(company);
        PhoneNumber savedPhoneNumber = phoneNumberRepository.save(phoneNumber);

        // then
        assertThat(savedCompany)
                .extracting(Company::getName, Company::getEmail)
                .containsExactly(company.getName(), company.getEmail());

        Set<PhoneNumber> phoneNumberListOfCompany = savedCompany.getPhoneNumberList();
        assertThat(phoneNumberListOfCompany).hasSize(1);
        assertThat(phoneNumberListOfCompany.stream().findAny().orElseThrow())
                .extracting(PhoneNumber::getNumber, PhoneNumber::getPhoneNumberType)
                .containsExactly(savedPhoneNumber.getNumber(), savedPhoneNumber.getPhoneNumberType());
    }

    @Test
    void thatFailsWhenPhoneNumberSavedWithoutCompany() {
        // given
        company.setPhoneNumberList(Set.of(phoneNumber));

        // when
        Assertions.assertThrows(DataIntegrityViolationException.class, () -> phoneNumberRepository.save(phoneNumber));
    }
}
