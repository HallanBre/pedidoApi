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
    EmailService eService;
  

    // listar
    public List<Pedido> listaPedido() {

        List<Pedido> pedidos = new ArrayList<>();
        pedidos = repository.findAll();
        return pedidos;
    }

    

    // CADASTRAR
    public void cadastroPedido(Pedido pedido) {
        pedido.setData(LocalDate.now());
        for (Produto produto : pedido.getProdutos()) {
            double valorTot = pedido.getValorTotal() + produto.getPreco();
            pedido.setValorTotal(valorTot);
        }
        repository.save(pedido);
        eService.sendPedidoEmail(pedido);

    
      

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
