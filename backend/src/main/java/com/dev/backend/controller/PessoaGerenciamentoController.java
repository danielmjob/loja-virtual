package com.dev.backend.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.backend.entity.Pessoa;
import com.dev.backend.service.PessoaGerenciamentoService;

@RestController
@RequestMapping("api/pessoa-gerenciamento")
public class PessoaGerenciamentoController {

    @Autowired
    private PessoaGerenciamentoService pessoaGerenciamentoService;

    @PostMapping("/senha-codigo")
    public String recuperarCodigo(@RequestBody Pessoa pessoa){
       
        return pessoaGerenciamentoService.solicitarCodigo(pessoa.getEmail());
    }

        @PostMapping("/senha-alterar")
    public String alterarSenha(@RequestBody Pessoa pessoa){
       
        return pessoaGerenciamentoService.alterarSenha(pessoa);
    }

    // testando senha-codigo Postman
    // Post
    //http://localhost:8080/api/pessoa-gerenciamento/senha-codigo
    // {
    //     "email":"danielmarquesjob@gmail.com" emailcadastrado
    // }

    // testando senha-alterar Postman
    //Post 
    //http://localhost:8080/api/pessoa-gerenciamento/senha-alterar
    // {
    //     "email":"danielmarquesjob@gmail.com",
    //     "codigoRecuperacaoSenha":"23082023112317231", codigo que recebeu por email
    //     "senha":"123321" nova senha
    // }


}
