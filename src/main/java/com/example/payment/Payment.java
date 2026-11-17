package com.example.payment;

import java.math.BigDecimal;

public class Payment {
    private final String payerName;
    private final String paymentId;
    private final BigDecimal amount;

    public Payment(String payerName, String paymentId, BigDecimal amount) {
        this.payerName = payerName;
        this.paymentId = paymentId;
        this.amount = amount;
    }

    public String getPayerName() {
        return payerName;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public BigDecimal getAmount() {
        return amount;
    }
}
