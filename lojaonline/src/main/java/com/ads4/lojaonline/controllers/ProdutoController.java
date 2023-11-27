package com.ads4.lojaonline.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ads4.lojaonline.entities.Produto;
import com.ads4.lojaonline.repository.ProdutoRepository;
import com.ads4.lojaonline.services.ProdutoService;

@RestController
@RequestMapping(value = "/produto")
public class ProdutoController {

    @Autowired
    ProdutoService service;

    @Autowired
    ProdutoRepository pRepository;

    @GetMapping("/lista")
    public List<Produto> getObject(){
        return service.listaProduto();
    }

    @PostMapping("/cadastro")
    public String cadastro(Produto produto){
        return service.cadastroProduto(produto);
    }

    @GetMapping("/busca/{id}")
    public Produto getObjectId(@PathVariable("id") int id){
        return service.BuscarID(id);
    }

    @GetMapping("/excluir/{id}")
    public String DeleteId(@PathVariable("id") int id){
        return service.excluirID(id);
    }
    
    
}
