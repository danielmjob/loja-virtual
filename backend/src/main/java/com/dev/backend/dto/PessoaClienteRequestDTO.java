package com.dev.backend.dto;

import org.springframework.beans.BeanUtils;

import com.dev.backend.entity.Pessoa;

import lombok.Data;

@Data
public class PessoaClienteRequestDTO {
    
    private String nome;
    private String cpf;
    private String email;
    private String endereco;
    private String cep;
    private String cidade;

    // Conversão de DTO para Pessoa
    public Pessoa converter(PessoaClienteRequestDTO pessoaClienteRequestDTO){
        Pessoa pessoa = new Pessoa();
        BeanUtils.copyProperties(pessoaClienteRequestDTO, pessoa); // tipo que tenho para o tipo que vou converter
        return pessoa;
    }

    

}
