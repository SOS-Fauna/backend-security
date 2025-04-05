package com.security.demo.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "reset_senha_orgao")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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
}
