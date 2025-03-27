package com.security.demo.controller;

import com.security.demo.model.dto.*;
import com.security.demo.service.AuthService;
import com.security.demo.service.ResetSenhaService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register/user")
    public String registerUser(@RequestBody RegistrarUsuarioDTO body) {
        authService.registerUser(body.getEmail(), body.getSenha());
        return "User registered successfully";
    }

    @PostMapping("/register/ong")
    public String registerOng(@RequestBody RegistrarOrgaoDTO body) {
        authService.registerOng(body.getEmail(), body.getSenha());
        return "ONG registered successfully";
    }

    @PostMapping("/login/user")
    public String loginUser(@RequestBody LoginUsuarioDTO body) {
        return authService.authenticateUser(body.getEmail(), body.getSenha());
    }

    @PostMapping("/login/ong")
    public String loginOng(@RequestBody LoginOrgaoDTO body) {
        return authService.authenticateOng(body.getEmail(), body.getSenha());
    }


}
