package com.security.demo.controller;

import com.security.demo.model.dto.*;
import com.security.demo.service.AuthService;
import com.security.demo.service.RegisterService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Autenticação", description = "Operações de registro e login")
@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class AuthController {

    private static final Logger log = LoggerFactory.getLogger(AuthController.class);
    private AuthService authService;
    private RegisterService registerService;

    @Operation(summary = "Criar Usuário", description = "Cria um usuário, validando seu email")
    @PostMapping("/register/user")
    public ResponseEntity<String> registerUser(@RequestBody RegistrarUsuarioDTO body) {
        try {
            if (!body.getEmail().matches("^[^\\s@]+@[^\\s@]+\\.[^\\s@]+$")) {
                throw new IllegalArgumentException("Email de usuário inválido");
            }
            registerService.registerUser(body.getEmail(), body.getSenha());
            return ResponseEntity.ok("Usuário registrado com sucesso!");
        }
        catch (IllegalArgumentException e) {
            log.warn("Erro ao registrar email de usuário", e.getMessage());
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @Operation(summary = "Criar ONG", description = "Cria uma ONG, validando seu email")
    @PostMapping("/register/ong")
    public ResponseEntity<String> registerOng(@RequestBody RegistrarOrgaoDTO body) {
        try {
            if (!body.getEmail().matches("^[^\\s@]+@[^\\s@]+\\.[^\\s@]+$")) {
                throw new IllegalArgumentException("Email de ONG inválido");
            }
            registerService.registerOng(body.getEmail(), body.getSenha());
            return ResponseEntity.ok("ONG registrada com sucesso!");
        }
        catch (IllegalArgumentException e) {
            log.warn("Erro ao registrar email de ONG", e.getMessage());
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @Operation(summary = "Login Usuário", description = "Verifica o email inserido, e assim permite o login do mesmo.")
    @PostMapping("/login/user")
    public String loginUser(@RequestBody LoginUsuarioDTO body) {
        return authService.authenticateUser(body.getEmail(), body.getSenha());
    }

    @Operation(summary = "Login ONG", description = "Verifica o email inserido, e assim permite o login do mesmo.")
    @PostMapping("/login/ong")
    public String loginOng(@RequestBody LoginOrgaoDTO body) {
        return authService.authenticateOng(body.getEmail(), body.getSenha());
    }
}
