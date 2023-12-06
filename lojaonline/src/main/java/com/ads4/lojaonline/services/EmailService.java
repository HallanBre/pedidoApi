package com.ads4.lojaonline.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.ads4.lojaonline.entities.Pedido;
import com.ads4.lojaonline.entities.Produto;
import com.ads4.lojaonline.repository.EmailRepository;

@Service
public class EmailService {

    @Autowired
    EmailRepository emailRepository;
    @Autowired
    JavaMailSender emailSender;

    

    public void sendPedidoEmail(Pedido pedido) {
        
        //CONSTRUTOR DO EMAIL
         StringBuilder textoEmail = new StringBuilder();
            textoEmail.append("Pedido:").append(pedido.getId()).append("\n-------------------------\n");
            for (Produto produto : pedido.getProdutos()) {
                textoEmail.append(produto.getNome() + " " + produto.getPreco());
                textoEmail.append("\n");
            }
            textoEmail.append("\n-------------------------\n" + "VALOR TOTAL: " + pedido.getValorTotal());
            //FIM DO CONSTRUTOR
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("halllanbandrad@gmail.com");
        message.setTo("hallanbandrade@gmail.com");
        message.setSubject("Detalhes do Pedido");
        message.setText(textoEmail.toString());
        emailSender.send(message);
    }
   
    
}
