package com.dev.backend.controller;

import java.util.Date;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// Responsavel pelas requisições do Front, essa foi criada apenas para teste inicial da aplicação
@RestController
@RequestMapping("/api")
public class Hello {

    @GetMapping("/")
    public String hello(){
        return "Olá mundo String " + new Date();
    }
    
}
