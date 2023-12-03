package com.ads4.lojaonline.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.ads4.lojaonline.entities.Email;
import com.ads4.lojaonline.entities.Pedido;
import com.ads4.lojaonline.entities.Produto;
import com.ads4.lojaonline.entities.Usuario;
import com.ads4.lojaonline.enums.StatusEmail;
import com.ads4.lojaonline.repository.EmailRepository;
import com.ads4.lojaonline.repository.PedidoRepository;
import com.ads4.lojaonline.repository.UsuarioRepository;

@Service
public class PedidoService {

    @Autowired
    PedidoRepository repository;
    @Autowired
    UsuarioRepository usuarioRepository;
    @Autowired
    EmailRepository emailRepository;
    @Autowired
    private JavaMailSender emailSender;

    // listar
    public List<Pedido> listaPedido() {

        List<Pedido> pedidos = new ArrayList<>();
        pedidos = repository.findAll();
        return pedidos;

    }

    // CADASTRAR
    public String cadastroPedido(Pedido pedido) {
        Email email = new Email();
        try {
            for (Produto produto : pedido.getProdutos()) {
                double valorTot = pedido.getValorTotal() + produto.getPreco();
                pedido.setValorTotal(valorTot);
            }

            pedido.setData(LocalDate.now());
            repository.save(pedido);

            // METODO PARA MANDAR O EMAIL COM TODOS OS DADOS
            email.setOwnerRef("Lanchonete");
            email.setEmailFrom("halllanbandrad@gmail.com");
            email.setEmailTo("hallanbandrade@gmail.com");
            email.setSubject("Pedido:" + pedido.getId());

            // ONDE O EMAIL VAI SER CONSTRUIDO
            StringBuilder textoEmail = new StringBuilder();
            textoEmail.append("Pedido:").append(pedido.getId()).append("\n-------------------------\n");
            for (Produto produto : pedido.getProdutos()) {
                textoEmail.append(produto.getNome() + " " + produto.getPreco());
                textoEmail.append("\n");
            }
            textoEmail.append("\n-------------------------\n" + "VALOR TOTAL: " + pedido.getValorTotal());
            //FIM DA CONSTRUÇÃO DO EMAIL
            email.setText(textoEmail.toString());
            //ENVIO DO EMAIL
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(email.getEmailFrom());
            message.setTo(email.getEmailTo());
            message.setSubject(email.getSubject());
            message.setText(email.getText());
            emailSender.send(message);

            email.setStatusEmail(StatusEmail.SENT);
            return "";
        } catch (Exception e) {
            email.setStatusEmail(StatusEmail.ERROR);
            return "erro" + e.getMessage();
        } finally {
            emailRepository.save(email);
        }

    }

    public Pedido BuscarID(int id) {
        Pedido pedidos = new Pedido();
        pedidos = repository.findById(id);
        return pedidos;
    }

    public String excluirID(int id) {

        repository.deleteById(id);
        return "";
    }
}
