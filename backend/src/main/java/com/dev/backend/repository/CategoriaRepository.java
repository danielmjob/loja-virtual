package com.dev.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.backend.entity.Categoria;

// responsavel por acessar o banco de dados
public interface CategoriaRepository extends JpaRepository<Categoria, Long>{
    
}
