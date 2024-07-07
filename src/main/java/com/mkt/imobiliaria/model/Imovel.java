package com.mkt.imobiliaria.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "imovel")
@Getter
@Setter
public class Imovel {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="imovel_sequence")
    @SequenceGenerator(name="imovel_sequence", sequenceName="imovel_seq", allocationSize = 1)
    @Column(name = "IMOVEL_ID", nullable = false)
    private Long id;

    private int areaConstruida;
    private String codigo;
    private BigDecimal precoAluguel;
    private BigDecimal precoVenda;
    private int qtdBanheiros;
    private int qtdQuartos;
    private int qtdSuites;
    private int qtdVagas;
    private int tamanhoTotal;
    private TipoDeOperacao tipoDeOperacao;
    private TipoDeImovel tipoImovel;

    @Column(name = "data_de_criacao", insertable = false, updatable = false)
    private Date dataDeCriacao;
    @Column(name = "data_de_atualizacao", insertable = false, updatable = false)
    private Date dataDeAtualizacao;

    @ManyToMany(mappedBy = "imoveis", fetch = FetchType.LAZY)
    private Set<Imobiliaria> imobiliarias = new HashSet<>();

    @OneToMany(mappedBy = "imovel", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Imagem> imagens;

    @OneToOne
    @JoinColumn(name = "endereco_id", referencedColumnName = "endereco_id")
    private Endereco endereco;

}

