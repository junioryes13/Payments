package com.leonardo.payments.model;

import com.leonardo.payments.model.DTO.PaymentRequest;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
@Entity
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    private Double value;
    @NotNull
    private int payer;

    @NotNull
    private int payee;

    private LocalDateTime dateTransaction;

    public Payment(Double value, int payer, int payee) {
        this.value = value;
        this.payer = payer;
        this.payee = payee;
        this.dateTransaction = LocalDateTime.now();
    }

    public Payment(PaymentRequest payment) {
        this.value = payment.getValue();
        this.payer = payment.getPayer();
        this.payee = payment.getPayee();
        this.dateTransaction = LocalDateTime.now();
    }

    public Double getValue() {
        return value;
    }

    public     @NotNull
    int getPayer() {
        return payer;
    }

    public     @NotNull
    int getPayee() {
        return payee;
    }

    public LocalDateTime getDateTransaction() {
        return dateTransaction;
    }

    public int getId() {
        return id;
    }

    @Deprecated
    public Payment() {
    }
}
