package com.example.springdata_hibernate.repository;

import com.example.springdata_hibernate.IntegrationTestHelper;
import com.example.springdata_hibernate.entity.Check;
import com.example.springdata_hibernate.entity.CreditCard;
import com.example.springdata_hibernate.entity.Payment;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;

public class PaymentRepositoryTest extends IntegrationTestHelper {

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
                .containsExactly("123456", 12345d);
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
                .containsExactly("12356", 1244d);
    }
}
