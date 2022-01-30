package com.example.springdata_hibernate.repository;

import com.example.springdata_hibernate.IntegrationTestHelper;
import com.example.springdata_hibernate.entity.inheritance_strategies.single_table.Check;
import com.example.springdata_hibernate.entity.inheritance_strategies.single_table.CreditCard;
import com.example.springdata_hibernate.entity.inheritance_strategies.single_table.Payment;
import com.example.springdata_hibernate.repository.inheritance_strategies.single_table.PaymentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;

public class SingleTableInheritanceTest extends IntegrationTestHelper {

    @Autowired
    private PaymentRepository paymentRepository;

    @Test
    void thatSaveCreditCardPaymentWorks() {
        // given
        CreditCard creditCard = new CreditCard();
        creditCard.setCardNumber("123456");
        creditCard.setAmount(12345d);

        // when
        CreditCard savedPayment = paymentRepository.save(creditCard);

        // then
        assertThat(savedPayment)
                .extracting(CreditCard::getCardNumber, Payment::getAmount)
                .containsExactly(creditCard.getCardNumber(), creditCard.getAmount());
    }

    @Test
    void thatSaveCheckPaymentWorks() {
        // given
        Check check = new Check();
        check.setAmount(1244d);
        check.setCheckNumber("12356");

        // when
        Check savedPayment = paymentRepository.save(check);

        // then
        assertThat(savedPayment)
                .extracting(Check::getCheckNumber, Payment::getAmount)
                .containsExactly(check.getCheckNumber(), check.getAmount());
    }
}
