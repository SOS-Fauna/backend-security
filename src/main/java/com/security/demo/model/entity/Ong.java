package com.security.demo.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;

@Entity
@Table(name = "orgaos_login")
public class Ong {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private String id;

    @Email
    @Column(name = "email")
    private String email;

    @Column(name = "senha")
    private String senha;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Ong(String id, String email, String senha) {
        this.id = id;
        this.email = email;
        this.senha = senha;
    }

    public Ong() {
    }
}