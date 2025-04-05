package com.security.demo.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "reset_senha_usuario")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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
}
