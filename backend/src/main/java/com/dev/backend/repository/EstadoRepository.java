package com.dev.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.backend.entity.Estado;

//Responsavel por acessar o banco de dados
public interface EstadoRepository extends JpaRepository<Estado, Long>{
    
}
