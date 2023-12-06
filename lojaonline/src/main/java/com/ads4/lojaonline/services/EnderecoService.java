package com.ads4.lojaonline.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ads4.lojaonline.entities.Endereco;
import com.ads4.lojaonline.repository.EnderecoRepository;

public class EnderecoService {
     @Autowired
    EnderecoRepository repository;
    
    public List<Endereco> listaProduto(){

        List<Endereco> endereco = new ArrayList<>();
        endereco = repository.findAll();
        return endereco;
    }
    public String cadastroProduto(Endereco endereco){
        repository.save(endereco);
        return "";
    }

    public Endereco BuscarID(int id){
        Endereco endereco = new Endereco();
        endereco = repository.findById(id);
        return endereco;
    }
    public String excluirID(int id){
        repository.deleteById(id);
        return "";
    }
}
