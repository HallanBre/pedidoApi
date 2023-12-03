package com.ads4.lojaonline.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ads4.lojaonline.entities.Usuario;
import com.ads4.lojaonline.services.UsuarioService;

@RestController
@RequestMapping(value = "/usuario")
public class UsuarioController {

    @Autowired
    UsuarioService service;

    @PostMapping("/cadastro")
    public String cadastro(Usuario usuario) {
        return service.salvar(usuario);
    }

    @GetMapping("/excluir/{id}")
    public String excluirUsuario(@PathVariable("id") int id) {
        return service.excluirUsuario(id);
    }

    @GetMapping("/lista")
    public List<Usuario> getObject(){
        return service.listaUsuario();
    }

}
