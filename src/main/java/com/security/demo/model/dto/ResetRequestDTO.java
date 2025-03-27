package com.security.demo.model.dto;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ResetRequestDTO {
    private EmailDTO email;
    private String codigo;

    public EmailDTO getEmail() {
        return email;
    }

    public void setEmail(EmailDTO email) {
        this.email = email;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
}