package com.ads4.lojaonline.entities;


import java.time.LocalDateTime;

import java.util.Set;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;


@Entity
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private LocalDateTime data;
    private double valorTotal;

   

    @ManyToOne(cascade = CascadeType.REFRESH)
    private Usuario usuario;

    @OneToMany(cascade = CascadeType.REFRESH)
    private Set<Produto> produtos;

  

    public Pedido(int id, LocalDateTime data, Usuario usuario, Set<Produto> produtos, double valorTotal) {
        this.id = id;
        this.data = LocalDateTime.now();
        this.usuario = usuario;
        this.produtos = produtos;
        this.valorTotal = valorTotal;
    }

    public Pedido() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

      public Set<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(Set<Produto> produtos) {
        this.produtos = produtos;
    }

     public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

}
