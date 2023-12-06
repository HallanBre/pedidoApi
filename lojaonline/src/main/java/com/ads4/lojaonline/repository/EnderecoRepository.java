package com.ads4.lojaonline.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ads4.lojaonline.entities.Endereco;
import com.ads4.lojaonline.entities.Pedido;

public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {
    Endereco findById(int id);
}

