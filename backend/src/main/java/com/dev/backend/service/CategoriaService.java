package com.dev.backend.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.backend.entity.Categoria;
import com.dev.backend.repository.CategoriaRepository;


//Concentra toda a regra de negocio


@Service
public class CategoriaService {
    
    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<Categoria> buscarTodos(){
        return categoriaRepository.findAll();
    }

    // se o id estiver null ele entende que deverá criar um nova Categoria
    public Categoria inserir(Categoria categoria){
        categoria.setDataCriacao(new Date());
        Categoria categoriaNova = categoriaRepository.saveAndFlush(categoria);
        return categoriaNova;
    }


    // se o id NÃO estiver null ele entende que deverá ALTERAR um Categoria existente
    public Categoria alterar (Categoria categoria){
        categoria.setDataAtualizacao(new Date());
        return categoriaRepository.saveAndFlush(categoria);
    }


    public void excluir(Long id){
        Categoria categoria = categoriaRepository.findById(id).get();// o findeById retorna um optional então uso o get para pegar a classe
        categoriaRepository.delete(categoria);

        // as exeções serão tratadas depois
    }
}
