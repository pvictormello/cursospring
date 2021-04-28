package com.paulovictor.cursomc.services;

import com.paulovictor.cursomc.domain.Pedido;
import org.springframework.mail.SimpleMailMessage;


public interface EmailService {

    void sendOrderConfirmationEmail(Pedido obj);

    void sendEmail(SimpleMailMessage msg);
}
