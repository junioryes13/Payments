package com.leonardo.payments.model;

import com.leonardo.payments.model.DTO.UserRequest;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;

import javax.persistence.PrimaryKeyJoinColumn;

@Entity(name = "usuario")
@PrimaryKeyJoinColumn(name="id")
public class User extends People {

    @NotBlank
    @org.hibernate.validator.constraints.br.CPF
    @jakarta.persistence.Column(unique = true)
    private String CPF;

    public User(String CPF, String nome, String senha, String telefone, String email) {
        super(nome, senha, telefone, email);
        this.CPF = CPF;
    }

    public User(UserRequest request) {
        super(request.getNome(), request.getSenha(), request.getTelefone(), request.getEmail());
        this.CPF = request.getCpf();
    }

    public String getCPF() {
        return CPF;
    }

    @Deprecated
    public User() {
    }
}
