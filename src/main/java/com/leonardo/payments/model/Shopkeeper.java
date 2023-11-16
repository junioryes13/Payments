package com.leonardo.payments.model;

import com.leonardo.payments.model.DTO.ShopkeeperRequest;
import jakarta.validation.constraints.NotBlank;

import javax.persistence.*;

@jakarta.persistence.Entity
@PrimaryKeyJoinColumn(name="id")
public class Shopkeeper extends People {
    @NotBlank
    @org.hibernate.validator.constraints.br.CNPJ
    @jakarta.persistence.Column(unique = true)
    private String cnpj;

    public Shopkeeper(ShopkeeperRequest request) {
        super(request.getNome(), request.getSenha(), request.getTelefone(), request.getEmail());
        this.cnpj = request.getCnpj();
    }

    public String getCNPJ() {
        return cnpj;
    }

    public Shopkeeper() {
    }
}
