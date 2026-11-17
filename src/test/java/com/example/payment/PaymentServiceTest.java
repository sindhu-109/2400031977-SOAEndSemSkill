package com.example.payment;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PaymentServiceTest {

    private PaymentService paymentService;

    @BeforeEach
    void setUp() {
        paymentService = new PaymentService();
    }

    @Test
    void shouldProcessValidPayment() {
        Payment payment = new Payment(
                "Sindhu",
                "PAY1001",
                new BigDecimal("1500.00")
        );

        String result = paymentService.processPayment(payment);

        assertThat(paymentService.validatePaymentDetails(payment)).isTrue();
        assertThat(result).contains("Payment processed successfully")
                .contains("PAY1001");
    }

    @Test
    void shouldRejectInvalidAmount() {
        Payment payment = new Payment(
                "Sindhu",
                "PAY1002",
                new BigDecimal("-500.00")
        );

        assertThat(paymentService.validatePaymentDetails(payment)).isFalse();
        assertThatThrownBy(() -> paymentService.processPayment(payment))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Invalid payment details or amount");
    }

    @Test
    void shouldRejectMissingDetails() {
        Payment payment = new Payment(
                "",
                null,
                new BigDecimal("100.00")
        );

        assertThat(paymentService.validatePaymentDetails(payment)).isFalse();
        assertThatThrownBy(() -> paymentService.processPayment(payment))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Invalid payment details or amount");
    }

    @Test
    void shouldRejectNullPayment() {
        assertThat(paymentService.validatePaymentDetails(null)).isFalse();
        assertThatThrownBy(() -> paymentService.processPayment(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Payment details are missing");
    }
}
