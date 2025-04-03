package com.security.demo.model.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "reset_senha_orgao")
public class ResetSenhaOng {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @OneToOne
    @JoinColumn(name = "orgao_id", referencedColumnName = "id")
    private Ong ong;

    @Column(name = "codigo_orgao")
    private String codigoOng;

    @Column(name = "data_de_expiracao_orgao")
    private LocalDateTime expirationOng;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Ong getOng() {
        return ong;
    }

    public void setOng(Ong ong) {
        this.ong = ong;
    }

    public String getCodigoOng() {
        return codigoOng;
    }

    public void setCodigoOng(String codigoOng) {
        this.codigoOng = codigoOng;
    }

    public LocalDateTime getExpirationOng() {
        return expirationOng;
    }

    public void setExpirationOng(LocalDateTime expirationOng) {
        this.expirationOng = expirationOng;
    }

    public ResetSenhaOng(String id, Ong ong, String codigoOng, LocalDateTime expirationOng) {
        this.id = id;
        this.ong = ong;
        this.codigoOng = codigoOng;
        this.expirationOng = expirationOng;
    }

    public ResetSenhaOng() {
    }
}
