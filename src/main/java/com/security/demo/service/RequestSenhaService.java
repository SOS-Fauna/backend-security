package com.security.demo.service;

import com.security.demo.model.dto.EmailDTO;
import com.security.demo.model.entity.Ong;
import com.security.demo.model.entity.ResetSenhaOng;
import com.security.demo.model.entity.ResetSenhaUser;
import com.security.demo.model.entity.User;
import com.security.demo.repository.OngRepository;
import com.security.demo.repository.ResetSenhaRepositoryOng;
import com.security.demo.repository.ResetSenhaRepositoryUser;
import com.security.demo.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class RequestSenhaService {

    private final UserRepository userRepository;
    private final OngRepository ongRepository;
    private final ResetSenhaRepositoryUser resetSenhaRepositoryUser;
    private final ResetSenhaRepositoryOng resetSenhaRepositoryOng;
    private final SendEmailService sendEmailService;

    public RequestSenhaService(UserRepository userRepository, OngRepository ongRepository, ResetSenhaRepositoryUser resetSenhaRepositoryUser, ResetSenhaRepositoryOng resetSenhaRepositoryOng, JavaMailSender javaMailSender, SendEmailService sendEmailService) {
        this.userRepository = userRepository;
        this.ongRepository = ongRepository;
        this.resetSenhaRepositoryUser = resetSenhaRepositoryUser;
        this.resetSenhaRepositoryOng = resetSenhaRepositoryOng;
        this.sendEmailService = sendEmailService;
    }

    @Transactional
    public void solicitarResetSenhaUser(EmailDTO email) {
        User user = userRepository.findByEmail(email.getEmail()).orElse(null);
        if (user != null) {
            String codigo = UUID.randomUUID().toString().substring(0, 6);
            ResetSenhaUser resetSenhaUser = new ResetSenhaUser();
            resetSenhaUser.setUser(user);
            resetSenhaUser.setCodigoUser(codigo);
            resetSenhaUser.setExpirationUser(LocalDateTime.now().plusHours(1));
            resetSenhaRepositoryUser.save(resetSenhaUser);
            sendEmailService.enviarEmailResetSenha(user.getEmail(), codigo);
        }
    }

    @Transactional
    public void solicitarResetSenhaOng(EmailDTO email) {
        Ong ong = ongRepository.findByEmail(email.getEmail()).orElse(null);
        if (ong != null) {
            String codigo = UUID.randomUUID().toString().substring(0, 6);
            ResetSenhaOng resetSenhaOng = new ResetSenhaOng();
            resetSenhaOng.setOng(ong);
            resetSenhaOng.setCodigoOng(codigo);
            resetSenhaOng.setExpirationOng(LocalDateTime.now().plusHours(1));
            resetSenhaRepositoryOng.save(resetSenhaOng);
            sendEmailService.enviarEmailResetSenha(ong.getEmail(), codigo);
        }
    }
}
