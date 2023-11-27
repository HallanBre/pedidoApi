package com.ads4.lojaonline.services;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ads4.lojaonline.entities.Pedido;
import com.ads4.lojaonline.repository.PedidoRepository;

@Service
public class PedidoService {

    @Autowired
    PedidoRepository repository;

    // listar
    public List<Pedido> listaPedido() {

        List<Pedido> pedidos = new ArrayList<>();
        pedidos = repository.findAll();
        return pedidos;

    }

    // CADASTRAR
    public String cadastroPedido(Pedido pedido) {
        pedido.setData(LocalDateTime.now());
        repository.save(pedido);
        return "";
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
