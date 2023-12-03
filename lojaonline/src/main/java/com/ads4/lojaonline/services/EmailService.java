package com.ads4.lojaonline.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.ads4.lojaonline.entities.Pedido;
import com.ads4.lojaonline.repository.EmailRepository;

@Service
public class EmailService {

    @Autowired
    EmailRepository emailRepository;
    @Autowired
    JavaMailSender emailSender;

    public void sendPedidoEmail(Pedido pedido) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("halllanbandrad@gmail.com");
        message.setTo("hallanbandrad@gmail.com");
        message.setSubject("Detalhes do Pedido");
        message.setText(criarTextoPedido(pedido));
        emailSender.send(message);
    }
    private String criarTextoPedido(Pedido pedido) {
        // Aqui você formata a mensagem do e-mail com os detalhes do pedido
        return "Detalhes do Pedido: " + pedido.toString(); // Substitua com a formatação desejada
    }
    
}
