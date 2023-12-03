package com.ads4.lojaonline.controllers;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ads4.lojaonline.dto.EmailDto;
import com.ads4.lojaonline.entities.Email;
import com.ads4.lojaonline.entities.Pedido;
import com.ads4.lojaonline.services.EmailService;

import jakarta.validation.Valid;

@RestController
public class EmailController {

    @Autowired
    EmailService emailservice;

    @PostMapping("/sending-email")
    public ResponseEntity<Email> sendingEmail(@RequestBody @Valid EmailDto emailDto , Pedido pedido) {
        Email emailModel = new Email();
        BeanUtils.copyProperties(emailDto, emailModel);
        emailservice.sendPedidoEmail(pedido);
        return new ResponseEntity<>(emailModel, HttpStatus.CREATED);
    }

}
