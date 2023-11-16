package com.leonardo.payments.model.DTO;

import com.leonardo.payments.model.Payment;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


public class PaymentRequest {

    @NotNull
    private Double value;

    public Double getValue() {
        return value;
    }

    public int getPayer() {
        return payer;
    }

    public int getPayee() {
        return payee;
    }

    @NotNull
    private int payer;

    @NotNull
    private int payee;
    public Payment toModel() {
        Payment payment = new Payment(this.value, this.payer, this.payee);
        return payment;
    }

    public PaymentRequest() {
    }
}
