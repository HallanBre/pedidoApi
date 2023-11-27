package com.ads4.lojaonline.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.security.oauth2.core.user.OAuth2User;
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

    // public String salvar(Usuario usuario, @AuthenticationPrincipal OidcUser principal) {
    //     usuario.setEmail(principal.getAttribute("email"));
    //     usuario.setNome(principal.getAttribute("name"));
    //     System.out.println(usuario.getNome() + "" + usuario.getEmail());
    //     repository.save(usuario);
    //     return "";
    // }

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

      
}
