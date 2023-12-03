package com.ads4.lojaonline.dto;

import java.time.LocalDate;
import java.util.List;

import com.ads4.lojaonline.entities.Produto;
import com.ads4.lojaonline.entities.Usuario;

import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;


public class PedidoDto {
    private int id;
    private LocalDate data;
    private double valorTotal;

    @ManyToOne(cascade = CascadeType.REFRESH)
    private Usuario usuario;

        @ManyToMany(cascade = CascadeType.REFRESH)
    @JoinTable(name = "pedido_produtos", joinColumns = @JoinColumn(name = "pedido_id"), inverseJoinColumns = @JoinColumn(name = "produtos_id"))
    private List<Produto> produtos;




        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public LocalDate getData() {
            return data;
        }

        public void setData(LocalDate data) {
            this.data = data;
        }

        public double getValorTotal() {
            return valorTotal;
        }

        public void setValorTotal(double valorTotal) {
            this.valorTotal = valorTotal;
        }

        public Usuario getUsuario() {
            return usuario;
        }

        public void setUsuario(Usuario usuario) {
            this.usuario = usuario;
        }

        public List<Produto> getProdutos() {
            return produtos;
        }

        public void setProdutos(List<Produto> produtos) {
            this.produtos = produtos;
        }

        public PedidoDto(int id, LocalDate data, double valorTotal, Usuario usuario, List<Produto> produtos) {
            this.id = id;
            this.data = data;
            this.valorTotal = valorTotal;
            this.usuario = usuario;
            this.produtos = produtos;
        }
        public PedidoDto(){
            
        }
    
}
