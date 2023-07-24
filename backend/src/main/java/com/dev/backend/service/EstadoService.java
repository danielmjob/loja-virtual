package com.dev.backend.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.backend.entity.Estado;
import com.dev.backend.repository.EstadoRepository;

//Concentra toda a regra de negocio

@Service
public class EstadoService {
    
    @Autowired // substitui a necessidade de usar private EstadoRepository estadoRepository = new Estadorepository();
    private EstadoRepository estadoRepository;

    public List<Estado> buscarTodos(){
        return estadoRepository.findAll();
    }

    // se o id estiver null ele entende que deverá criar um novo Estado
    public Estado inserir(Estado estado){
        estado.setDataCriacao(new Date());
        Estado estadoNovo = estadoRepository.saveAndFlush(estado);
        return estadoNovo;
    }

    // se o id NÃO estiver null ele entende que deverá ALTERAR um Estado existente
    public Estado alterar(Estado estado){
        estado.setDataAtualizacao(new Date());
        return estadoRepository.saveAndFlush(estado);

    }

    public void excluir(Long id) {
        Estado estado = estadoRepository.findById(id).get();  // o findeById retorna um optional então uso o get para pegar a classe
        estadoRepository.delete(estado);

        // as exeções serão tratadas depois
    }

}
