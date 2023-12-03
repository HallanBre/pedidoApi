package com.ads4.lojaonline.services;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ads4.lojaonline.dto.UsuarioDto;

import com.ads4.lojaonline.entities.Usuario;
import com.ads4.lojaonline.repository.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

     public String salvar(Usuario usuario) {
         repository.save(usuario);
        return "";
     }

    public UsuarioDto buscaUsuario(int id) {
        Usuario usuario = new Usuario();
        usuario = repository.findById(id);
        UsuarioDto dto = new UsuarioDto(usuario);
        return dto;
    }

    public String excluirUsuario(int id) {
        repository.deleteById(id);
        return "";
    }
    public List<Usuario> listaUsuario(){
        List<Usuario> usuario = new ArrayList<>();
        usuario = repository.findAll();
        return usuario;
    }

      
}
