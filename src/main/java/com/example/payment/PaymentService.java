package com.example.payment;

import java.math.BigDecimal;

public class PaymentService {

    public boolean validatePaymentDetails(Payment payment) {
        if (payment == null) {
            return false;
        }

        return payment.getPayerName() != null
                && !payment.getPayerName().isBlank()
                && payment.getPaymentId() != null
                && !payment.getPaymentId().isBlank()
                && payment.getAmount() != null
                && payment.getAmount().compareTo(BigDecimal.ZERO) > 0;
    }

    public String processPayment(Payment payment) {
        if (payment == null) {
            throw new IllegalArgumentException("Payment details are missing");
        }

        if (!validatePaymentDetails(payment)) {
            throw new IllegalArgumentException("Invalid payment details or amount");
        }

        return "Payment processed successfully. Payment ID: " + payment.getPaymentId();
    }
}
