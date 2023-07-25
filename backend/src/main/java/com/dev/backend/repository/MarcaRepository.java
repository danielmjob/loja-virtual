package com.dev.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.backend.entity.Marca;

//Responsavel por acessar o banco de dados
public interface MarcaRepository extends JpaRepository<Marca, Long>{
    
}
