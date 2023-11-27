package com.ads4.lojaonline.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ads4.lojaonline.dto.UsuarioDto;
import com.ads4.lojaonline.entities.Usuario;
import com.ads4.lojaonline.services.UsuarioService;

@RestController
@RequestMapping(value = "/usuario")
public class UsuarioController {

    @Autowired
    UsuarioService service;

    // @PostMapping("/cadastro")
    // public String cadastroUsuario(Usuario usuario ) {
    //     return service.salvar(usuario, null);
    // }

    

    //pegar o email e nome do google
    //  @GetMapping("/busca/{id}")
    //  public UsuarioDto busca(@PathVariable("id") int id, @AuthenticationPrincipal OidcUser principal) {
    //      String email = principal.getAttribute("email");
    //      String nome = principal.getAttribute("name");

    //      System.out.println(email + "" + nome);
    //      return service.buscaUsuario(id);

    //  }

    @GetMapping("/excluir/{id}")
    public String excluirUsuario(@PathVariable("id") int id) {
        return service.excluirUsuario(id);
    }

  

}
