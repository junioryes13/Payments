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

    public Integer getPayer() {
        return payer;
    }

    public Integer getPayee() {
        return payee;
    }

    @NotNull
    private Integer payer;

    @NotNull
    private Integer payee;
    public Payment toModel() {
        Payment payment = new Payment(this.value, this.payer, this.payee);
        return payment;
    }

    public PaymentRequest() {
    }
}
