package com.security.demo.service;

import com.security.demo.model.entity.Ong;
import com.security.demo.model.entity.User;
import com.security.demo.repository.OngRepository;
import com.security.demo.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegisterService {

    private final UserRepository userRepository;
    private final OngRepository ongRepository;
    private final PasswordEncoder passwordEncoder;

    public void registerUser(String email, String senha) {
        User user = new User(null, email, passwordEncoder.encode(senha));
        userRepository.save(user);
    }

    public void registerOng(String email, String senha) {
        Ong ong = new Ong(null, email, passwordEncoder.encode(senha));
        ongRepository.save(ong);
    }
}
