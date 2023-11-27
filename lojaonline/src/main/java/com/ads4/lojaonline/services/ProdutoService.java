package com.ads4.lojaonline.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ads4.lojaonline.entities.Produto;
import com.ads4.lojaonline.repository.ProdutoRepository;



@Service
public class ProdutoService {
    
    @Autowired
    ProdutoRepository repository;


    public List<Produto> listaProduto(){

        List<Produto> produto = new ArrayList<>();
        produto = repository.findAll();
        return produto;
    }
    public String cadastroProduto(Produto produto){
        repository.save(produto);
        return "";
    }

    public Produto BuscarID(int id){
        Produto produto = new Produto();
        produto = repository.findById(id);
        return produto;
    }
    public String excluirID(int id){
        repository.deleteById(id);
        return "";
    }
}
