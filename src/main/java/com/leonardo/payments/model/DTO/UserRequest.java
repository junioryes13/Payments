package com.leonardo.payments.model.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CPF;

public class UserRequest {
    @CPF
    @NotBlank
    private String cpf;
    @NotBlank
    private String nome;

    @NotBlank
    private String senha;

    @NotBlank
    private String telefone;

    @NotBlank
    @Email
    private String email;

    private Double saldo;

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

    public String getCpf() {
        return cpf;
    }

    public Double getSaldo() {
        return saldo;
    }

    public UserRequest() {
    }
}
