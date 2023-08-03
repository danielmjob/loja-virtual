package com.dev.backend.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

// Atenção para as particularidades na Ligação muitos para muitos com a classe Pessoa

@Entity
@Table(name="permissao_pessoa")// ajuda a evitar problemas em diferentes SO's
@Data // adiciona getters e setters via lombok reduz código escrito
public class PermissaoPessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    
    @ManyToOne
    @JoinColumn(name = "idPessoa")
    @JsonIgnore // Para evitar loop eterno
    private Pessoa pessoa; // Esse nome de objeto esta sendo na Classe Pessoa no mappedby

    @ManyToOne
    @JoinColumn(name = "idPermissao")  
    private Permissao permissao;


    @Temporal(TemporalType.TIMESTAMP) // para informar que tipo sera usado se apenas data ou se data e hora
    private Date dataCriacao;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataAtualizacao;

    
}
