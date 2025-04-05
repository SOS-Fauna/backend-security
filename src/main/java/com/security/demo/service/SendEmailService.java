package com.security.demo.service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.AllArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

@Service
@AllArgsConstructor
public class SendEmailService {

    private final JavaMailSender javaMailSender;

    public void enviarEmailResetSenha(String email, String codigo) throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "UTF-8");

        helper.setTo(email);
        helper.setSubject("SOS Fauna - Reset de senha");
        helper.setText(gerarEmail("SOS Fauna", codigo), true);
        javaMailSender.send(mimeMessage);
    }

    public String gerarEmail(String titulo, String mensagem) {

        ClassLoaderTemplateResolver resolver = new ClassLoaderTemplateResolver();
        resolver.setSuffix(".html");
        resolver.setTemplateMode("HTML");
        resolver.setCharacterEncoding("UTF-8");

        TemplateEngine templateEngine = new TemplateEngine();
        templateEngine.setTemplateResolver(resolver);

        Context context = new Context();
        context.setVariable("titulo", titulo);
        context.setVariable("mensagem", mensagem);
        return templateEngine.process("templates/TemplateEmail.html", context);
    }
}
