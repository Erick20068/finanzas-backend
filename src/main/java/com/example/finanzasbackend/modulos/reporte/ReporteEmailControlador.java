package com.example.finanzasbackend.modulos.reporte;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;

import jakarta.mail.internet.MimeMessage;
import java.util.Map;

@RestController
@RequestMapping("/api/reporte")
public class ReporteEmailControlador {

    private final JavaMailSender mailSender;

    @Value("${spring.mail.username:}")
    private String from;

    public ReporteEmailControlador(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    @PostMapping("/enviar")
    public ResponseEntity<?> enviar(@AuthenticationPrincipal Jwt jwt,
                                     @RequestBody Map<String, Object> body) {
        try {
            String email = jwt.getClaimAsString("email");
            if (email == null || email.isBlank()) {
                return ResponseEntity.badRequest().body(Map.of("message", "No se pudo determinar tu correo"));
            }

            String nombre = String.valueOf(body.getOrDefault("nombre", "Usuario"));
            String periodo = String.valueOf(body.getOrDefault("periodo", ""));
            String html = String.valueOf(body.getOrDefault("html", "<p>Reporte Arca</p>"));

            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
            helper.setTo(email);
            if (from != null && !from.isBlank()) {
                helper.setFrom(from);
            }
            helper.setSubject("Arca — Reporte financiero (" + periodo + ")");
            helper.setText(
                "<p>Hola " + nombre + ",</p><p>Adjuntamos tu reporte del periodo <b>"
                    + periodo + "</b>.</p>" + html,
                true
            );

            mailSender.send(message);
            return ResponseEntity.ok(Map.of("message", "Reporte enviado a " + email));
        } catch (Exception e) {
            return ResponseEntity.badRequest()
                .body(Map.of("message", "Error al enviar correo"));
        }
    }
}