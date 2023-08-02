package com.dev.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.backend.entity.Produto;
import com.dev.backend.service.ProdutoService;

@RestController
@RequestMapping("api/produto")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping("/")
    public List<Produto> buscarTodos(){
        return produtoService.buscarTodos();
    }

    @PostMapping("/")
    public Produto inserir(@RequestBody Produto produto){
        return produtoService.inserir(produto);
    }

    /*
    Exemplo de cadastro no postman
    Post http://localhost:8080/api/produto/
     {
    "descricaoCurta":"Instrumento com uma descrição curta",
    "descricaoLonga":"Instrumento com uma descrição larga",
    "valorCusto":4000.00,
    "valorVenda":6000.00,
    
    "marca":{
        "id":1
    },

    "categoria":{
        "id":1
    }
    
}
     */

    @PutMapping("/")
    public Produto alterar(@RequestBody Produto produto){
        return produtoService.alterar(produto);
    }

    /*
    Exemplo de cadastro no postman
    Post http://localhost:8080/api/produto/
    
     {
    "id":1,
    "descricaoCurta":"Guitarra com uma descrição curta",
    "descricaoLonga":"Guitarra com uma descrição larga",
    "valorCusto":4500.00,
    "valorVenda":6000.00,
    
    "marca":{
        "id":1
    },

    "categoria":{
        "id":1
    }
    
}
     */

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable("id") Long id){
        produtoService.excluir(id);
        return ResponseEntity.ok().build();
    }

}
