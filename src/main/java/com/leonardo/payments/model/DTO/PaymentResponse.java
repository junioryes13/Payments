package com.leonardo.payments.model.DTO;

import com.leonardo.payments.model.Payment;

import javax.validation.constraints.NotBlank;


public class PaymentResponse {

    private Double value;

    public PaymentResponse(Payment payment) {
        this.payee = payment.getPayee();
        this.payer = payment.getPayer();
        this.value = payment.getValue();
    }

    public Double getValue() {
        return value;
    }

    public int getPayer() {
        return payer;
    }

    public int getPayee() {
        return payee;
    }

    private int payer;
    private int payee;



}
