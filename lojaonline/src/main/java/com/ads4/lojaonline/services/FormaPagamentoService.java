package com.ads4.lojaonline.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ads4.lojaonline.entities.FormaPagamento;
import com.ads4.lojaonline.repository.FormaPagamentoRepository;




public class FormaPagamentoService {
    @Autowired
    FormaPagamentoRepository repository;
    
    public List<FormaPagamento> listaProduto(){

        List<FormaPagamento> formaPag = new ArrayList<>();
        formaPag = repository.findAll();
        return formaPag;
    }
    public String cadastroProduto(FormaPagamento formaPag){
        repository.save(formaPag);
        return "";
    }

    public FormaPagamento BuscarID(int id){
        FormaPagamento formaPag = new FormaPagamento();
        formaPag = repository.findById(id);
        return formaPag;
    }
    public String excluirID(int id){
        repository.deleteById(id);
        return "";
    }
}
