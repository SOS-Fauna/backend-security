package com.security.demo.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "orgaos_login")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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
}