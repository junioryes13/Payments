package com.leonardo.payments.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;

@jakarta.persistence.MappedSuperclass
public abstract class People {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @jakarta.validation.constraints.NotBlank
    private String nome;

    @jakarta.validation.constraints.NotBlank
    private String senha;

    @jakarta.validation.constraints.NotBlank
    private String telefone;

    @jakarta.validation.constraints.NotBlank
    @Email
    private String email;

    private Double saldo;

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEmail() {
        return email;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public void atualizarSaldo(Double value) {
        this.saldo = value;
    }

    public People(String nome, String senha, String telefone, String email) {
        this.nome = nome;
        this.senha = senha;
        this.telefone = telefone;
        this.email = email;
        this.saldo = 0.0;
    }

    @Deprecated
    public People() {
    }

}