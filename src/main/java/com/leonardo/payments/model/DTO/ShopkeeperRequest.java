package com.leonardo.payments.model.DTO;

import jakarta.validation.constraints.NotBlank;

public class ShopkeeperRequest {

    @NotBlank
    private String nome;

    @NotBlank
    private String senha;

    @NotBlank
    private String telefone;

    @NotBlank
    private String email;

    @NotBlank
    @org.hibernate.validator.constraints.br.CNPJ
    private String cnpj;

    private Double saldo;

    public ShopkeeperRequest(String nome, String senha, String telefone, String email, String CNPJ) {

        this.nome = nome;
        this.senha = senha;
        this.telefone = telefone;
        this.email = email;
        this.cnpj = CNPJ;
        this.saldo = 0.0;
    }

    public String getNome() {
        return nome;
    }

    public String getSenha() {
        return senha;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEmail() {
        return email;
    }

    public String getCnpj() {
        return cnpj;
    }

    public Double getSaldo() {
        return saldo;
    }
}
