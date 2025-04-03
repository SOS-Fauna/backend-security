package com.security.demo.model.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "reset_senha_usuario")
public class ResetSenhaUser {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @OneToOne
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    private User user;

    @Column(name = "codigo_usuario")
    private String codigoUser;

    @Column(name = "data_de_expiracao_user")
    private LocalDateTime expirationUser;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getCodigoUser() {
        return codigoUser;
    }

    public void setCodigoUser(String codigoUser) {
        this.codigoUser = codigoUser;
    }

    public LocalDateTime getExpirationUser() {
        return expirationUser;
    }

    public void setExpirationUser(LocalDateTime expirationUser) {
        this.expirationUser = expirationUser;
    }

    public ResetSenhaUser(String id, User user, String codigoUser, LocalDateTime expirationUser) {
        this.id = id;
        this.user = user;
        this.codigoUser = codigoUser;
        this.expirationUser = expirationUser;
    }

    public ResetSenhaUser() {
    }
}
