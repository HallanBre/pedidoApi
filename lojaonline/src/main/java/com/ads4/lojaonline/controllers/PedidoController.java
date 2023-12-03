package com.ads4.lojaonline.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ads4.lojaonline.entities.Pedido;
import com.ads4.lojaonline.repository.PedidoRepository;
import com.ads4.lojaonline.services.PedidoService;



@RestController
@RequestMapping(value = "/pedido")
public class PedidoController {

    @Autowired
    PedidoService service;

    @GetMapping("/lista")
    public List<Pedido> getObject(){
        return service.listaPedido(); 
    }
   

   @PostMapping("/cadastro")
    public String cadastro(Pedido pedido){
            return service.cadastroPedido(pedido);
      
    }

     @GetMapping("/busca/{id}")
    public Pedido getObjectId(@PathVariable("id") int id){
        return service.BuscarID(id);
    }

    @GetMapping("/excluir/{id}")
    public String DeleteId(@PathVariable("id") int id){
       
        return service.excluirID(id);

    }

}