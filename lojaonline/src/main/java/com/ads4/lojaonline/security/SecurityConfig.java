// package com.ads4.lojaonline.security;

// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.config.Customizer;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// import org.springframework.security.web.SecurityFilterChain;

// @Configuration
// @EnableWebSecurity // Seja reconhecido como a classe que habilita a segurança web
// public class SecurityConfig {

//     // Filtros
//     @Bean // Varios filtros de segurança, como cadeia(configurações customizadas pe//
//           // usuário)
//     SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//         return http.authorizeHttpRequests(
//                 authorizeConfig -> {
//                     authorizeConfig.requestMatchers("/usuario/lista", "/produto/cadastro", "/sending-email").permitAll();
//                     authorizeConfig.anyRequest().authenticated();

//                 })

//                 .oauth2Login(Customizer.withDefaults())
//                 .build();
//     }

// }
