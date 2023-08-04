package com.dev.backend.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.backend.dto.PessoaClienteRequestDTO;
import com.dev.backend.entity.Pessoa;
import com.dev.backend.service.PessoaClienteService;

@RestController
@RequestMapping("api/cliente")
public class PessoaClienteControler {

    @Autowired
    private PessoaClienteService pessoaService;

    @PostMapping("/")
    public Pessoa inserir(@RequestBody PessoaClienteRequestDTO pessoaClienteRequestDTO){
        Pessoa pessoa = new PessoaClienteRequestDTO().converter(pessoaClienteRequestDTO);
        return pessoaService.registrar(pessoaClienteRequestDTO);
    }
     // Exemplo no postman
    // POST http://localhost:8080/api/pessoa/
    // {
    //     "nome":"Daniel",
    //     "cpf":"02047897106",
    //     "email":"daniel@gmail.com",
    //     "senha":"1234",
    //     "cep":"72622102",
    //     "cidade":{"id":3}
    //  }
    
}
