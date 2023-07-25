package com.dev.backend.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.backend.entity.Marca;
import com.dev.backend.repository.MarcaRepository;

//Concentra toda a regra de negocio
@Service
public class MarcaService {

    @Autowired
    private MarcaRepository marcaRepository;

    public List<Marca> buscarTodos(){
        return marcaRepository.findAll();
    }
// se o id estiver null ele entende que deverá criar um nova Marca
    public Marca inserir(Marca marca){
        marca.setDataCriacao(new Date());
        Marca marcaNova = marcaRepository.saveAndFlush(marca);
        return marcaNova;
        
    }
// se o id NÃO estiver null ele entende que deverá ALTERAR uma Marca existente
    public Marca alterar(Marca marca){
        marca.setDataAtualizacao(new Date());
        return marcaRepository.saveAndFlush(marca);
    }


    public void excluir(Long id){
        Marca marca = marcaRepository.findById(id).get();// o findeById retorna um optional então uso o get para pegar a classe
        marcaRepository.delete(marca);

        // as exeções serão tratadas depois
    }
    
}
