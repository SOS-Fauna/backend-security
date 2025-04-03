package com.security.demo.service;

import com.security.demo.model.entity.Ong;
import com.security.demo.model.entity.ResetSenhaOng;
import com.security.demo.model.entity.ResetSenhaUser;
import com.security.demo.model.entity.User;
import com.security.demo.repository.OngRepository;
import com.security.demo.repository.ResetSenhaRepositoryOng;
import com.security.demo.repository.ResetSenhaRepositoryUser;
import com.security.demo.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ResetSenhaService {

    private final UserRepository userRepository;
    private final OngRepository ongRepository;
    private final ResetSenhaRepositoryUser resetSenhaRepositoryUser;
    private final ResetSenhaRepositoryOng resetSenhaRepositoryOng;
    private final PasswordEncoder passwordEncoder;

    public ResetSenhaService(UserRepository userRepository,
                             OngRepository ongRepository,
                             ResetSenhaRepositoryUser resetSenhaRepositoryUser,
                             ResetSenhaRepositoryOng resetSenhaRepositoryOng,
                             PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.ongRepository = ongRepository;
        this.resetSenhaRepositoryUser = resetSenhaRepositoryUser;
        this.resetSenhaRepositoryOng = resetSenhaRepositoryOng;
        this.passwordEncoder = passwordEncoder;
    }

    public void resetSenhaUser(String codigo, String novaSenha) {
        ResetSenhaUser resetSenhaUser = resetSenhaRepositoryUser.findByCodigoUser(codigo).orElse(null);
        if (resetSenhaUser != null && resetSenhaUser.getExpirationUser().isAfter(LocalDateTime.now())) {
            User usuario = resetSenhaUser.getUser();
            usuario.setSenha(passwordEncoder.encode(novaSenha));
            userRepository.save(usuario);
            resetSenhaRepositoryUser.delete(resetSenhaUser);
        }
    }

    public void resetSenhaOrgao(String codigo, String novaSenha) {
        ResetSenhaOng resetSenhaOng = resetSenhaRepositoryOng.findByCodigoOng(codigo).orElse(null);
        if (resetSenhaOng != null && resetSenhaOng.getExpirationOng().isAfter(LocalDateTime.now())) {
            Ong ong = resetSenhaOng.getOng();
            ong.setSenha(passwordEncoder.encode(novaSenha));
            ongRepository.save(ong);
            resetSenhaRepositoryOng.delete(resetSenhaOng);
        }
    }
}
