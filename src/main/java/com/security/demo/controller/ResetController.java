package com.security.demo.controller;

import com.security.demo.model.dto.EmailDTO;
import com.security.demo.model.dto.ResetSenhaDTO;
import com.security.demo.service.RequestSenhaService;
import com.security.demo.service.ResetSenhaService;
import com.security.demo.service.SendEmailService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reset")
public class ResetController {

    private final ResetSenhaService resetSenhaService;
    private final RequestSenhaService requestSenhaService;

    public ResetController(ResetSenhaService resetSenhaService, RequestSenhaService requestSenhaService, SendEmailService sendEmailService) {
        this.resetSenhaService = resetSenhaService;
        this.requestSenhaService = requestSenhaService;
    }

    @PostMapping("/solicitar/user")
    public String solicitarResetSenhaUser(@RequestBody EmailDTO emailDTO) {
        requestSenhaService.solicitarResetSenhaUser(emailDTO);
        return "Token enviado";
    }

    @PostMapping("/executar/user")
    public String resetSenhaUser(@RequestBody ResetSenhaDTO resetSenhaDTO) {
        resetSenhaService.resetSenhaUser(resetSenhaDTO.getCodigo(), resetSenhaDTO.getNovaSenha());
        return "Senha alterada";
    }

    @PostMapping("/solicitar/ong")
    public String solicitarResetSenhaOng(@RequestBody EmailDTO emailDTO) {
        requestSenhaService.solicitarResetSenhaOng(emailDTO);
        return "Token enviado";
    }

    @PostMapping("/executar/ong")
    public String resetSenhaOng(@RequestBody ResetSenhaDTO resetSenhaDTO) {
        resetSenhaService.resetSenhaOrgao(resetSenhaDTO.getCodigo(), resetSenhaDTO.getNovaSenha());
        return "Senha alterada";
    }
}
