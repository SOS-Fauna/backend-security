package com.security.demo.controller;

import com.security.demo.model.dto.*;
import com.security.demo.service.AuthService;
import com.security.demo.service.RegisterService;
import com.security.demo.service.ResetSenhaService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class AuthController {

    @Autowired
    private AuthService authService;

    @Autowired
    private RegisterService registerService;

    @PostMapping("/register/user")
    public String registerUser(@RequestBody RegistrarUsuarioDTO body) {
        registerService.registerUser(body.getEmail(), body.getSenha());
        return "User registered successfully";
    }

    @PostMapping("/register/ong")
    public String registerOng(@RequestBody RegistrarOrgaoDTO body) {
        registerService.registerOng(body.getEmail(), body.getSenha());
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
