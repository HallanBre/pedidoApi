package com.ads4.lojaonline.dto;

import com.ads4.lojaonline.entities.Usuario;

public class UsuarioDto {

    private int id;
    private String nome;
    private String login;
    private String email;
    private String cpf;

    public UsuarioDto() {
    }

    public UsuarioDto(int id, String nome, String login, String email, String cpf) {
        this.id = id;
        this.nome = nome;
        this.login = login;
        this.email = email;
        this.cpf = cpf;
    }

    public UsuarioDto(Usuario usuario) {
        this.id = usuario.getId();
        this.nome = usuario.getNome();
        this.login = usuario.getLogin();
        this.email = usuario.getEmail();
        this.cpf = usuario.getCpf();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

}
