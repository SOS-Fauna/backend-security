package com.security.demo.controller;

import com.security.demo.model.dto.EmailDTO;
import com.security.demo.model.dto.ResetSenhaDTO;
import com.security.demo.service.RequestSenhaService;
import com.security.demo.service.ResetSenhaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Reset", description = "Operações de reset e envio de email")
@RestController
@RequestMapping("/reset")
@AllArgsConstructor
public class ResetController {

    private final ResetSenhaService resetSenhaService;
    private final RequestSenhaService requestSenhaService;

    @Operation(summary = "Solicitação de Usuário", description = "Envia um token para o email inserido pelo usuário")
    @PostMapping("/solicitar/user")
    public String solicitarResetSenhaUser(@RequestBody EmailDTO emailDTO) {
        requestSenhaService.solicitarResetSenhaUser(emailDTO);
        return "Token enviado";
    }

    @Operation(summary = "Reset de senha de Usuário", description = "Verifica o token digitado e insere uma nova senha de usuário")
    @PostMapping("/executar/user")
    public String resetSenhaUser(@RequestBody ResetSenhaDTO resetSenhaDTO) {
        resetSenhaService.resetSenhaUser(resetSenhaDTO.getCodigo(), resetSenhaDTO.getNovaSenha());
        return "Senha alterada";
    }

    @Operation(summary = "Solicitação de ONG", description = "Envia um token para o email inserido pelo usuário")
    @PostMapping("/solicitar/ong")
    public String solicitarResetSenhaOng(@RequestBody EmailDTO emailDTO) {
        requestSenhaService.solicitarResetSenhaOng(emailDTO);
        return "Token enviado";
    }

    @Operation(summary = "Reset de senha de ONG", description = "Verifica o token digitado e insere uma nova senha da ONG")
    @PostMapping("/executar/ong")
    public String resetSenhaOng(@RequestBody ResetSenhaDTO resetSenhaDTO) {
        resetSenhaService.resetSenhaOrgao(resetSenhaDTO.getCodigo(), resetSenhaDTO.getNovaSenha());
        return "Senha alterada";
    }
}
