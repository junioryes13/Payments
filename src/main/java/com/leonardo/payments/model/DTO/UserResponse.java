package com.leonardo.payments.model.DTO;

import com.leonardo.payments.model.User;

public class UserResponse {
    private String CPF;
    private String nome;
    private String telefone;
    private String email;
    private double saldo;

    public UserResponse(User n) {
        this.nome = n.getNome();
        this.CPF = n.getCPF();
        this.email = n.getEmail();
        this.telefone = n.getTelefone();
        this.saldo = n.getSaldo();
    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEmail() {
        return email;
    }

    public String getCPF() {
        return CPF;
    }

    public double getSaldo() {
        return saldo;
    }
}
