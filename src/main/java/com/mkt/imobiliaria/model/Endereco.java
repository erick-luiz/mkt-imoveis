package com.mkt.imobiliaria.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "endereco")
@Getter
@Setter
public class Endereco {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="endereco_sequence")
    @SequenceGenerator(name="endereco_sequence", sequenceName="endereco_seq", allocationSize = 1)
    @Column(name = "ENDERECO_ID", nullable = false)
    private Long id;

    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String estado;
    private String cep;

    @Column(name = "data_de_criacao", insertable = false, updatable = false)
    private Date dataDeCriacao;
    @Column(name = "data_de_atualizacao", insertable = false, updatable = false)
    private Date dataDeAtualizacao;

}
