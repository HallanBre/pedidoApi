package com.ads4.lojaonline.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ads4.lojaonline.entities.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

    Produto findById(int id);
}
