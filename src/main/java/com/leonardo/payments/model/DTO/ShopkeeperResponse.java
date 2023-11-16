package com.leonardo.payments.model.DTO;

import com.leonardo.payments.model.Shopkeeper;

public class ShopkeeperResponse {

    private String nome;

    private String telefone;

    private String email;

    private String CNPJ;

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEmail() {
        return email;
    }

    public String getCNPJ() {
        return CNPJ;
    }

    public ShopkeeperResponse(Shopkeeper shopkeeper) {
        this.nome = shopkeeper.getNome();
        this.CNPJ = shopkeeper.getCNPJ();
        this.email = shopkeeper.getEmail();
        this.telefone = shopkeeper.getTelefone();
    }
}
