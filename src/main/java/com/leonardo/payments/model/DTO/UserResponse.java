package com.leonardo.payments.model.DTO;

import com.leonardo.payments.model.User;

public class UserResponse {

    private String CPF;
    private String nome;
    private String telefone;
    private String email;

    public UserResponse(User n) {
        this.nome = n.getNome();
        this.CPF = n.getCPF();
        this.email = n.getEmail();
        this.telefone = n.getTelefone();
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

}
