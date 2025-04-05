package com.security.demo.service;

import com.security.demo.model.entity.User;
import com.security.demo.model.entity.Ong;
import com.security.demo.repository.UserRepository;
import com.security.demo.repository.OngRepository;
import com.security.demo.security.JwtUtil;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final OngRepository ongRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    public String authenticateUser(String email, String password) {
        Optional<User> user = userRepository.findByEmail(email);
        if (user.isPresent() && passwordEncoder.matches(password, user.get().getSenha())) {
            return jwtUtil.generateToken(email);
        }
        return "Invalid credentials";
    }

    public String authenticateOng(String email, String password) {
        Optional<Ong> ong = ongRepository.findByEmail(email);
        if (ong.isPresent() && passwordEncoder.matches(password, ong.get().getSenha())) {
            return jwtUtil.generateToken(email);
        }
        return "Invalid credentials";
    }
}
