package com.ads4.lojaonline.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ads4.lojaonline.entities.FormaPagamento;
import com.ads4.lojaonline.entities.Pedido;

public interface FormaPagamentoRepository extends JpaRepository<FormaPagamento, Integer> {
    FormaPagamento findById(int id);
}
