package com.mkt.imobiliaria.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "imobiliaria")
@Getter
@Setter
public class Imobiliaria {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="imobiliaria_sequence")
    @SequenceGenerator(name="imobiliaria_sequence", sequenceName="imobiliaria_seq", allocationSize = 1)
    @Column(name = "IMOBILIARIA_ID", nullable = false)
    private Long id;

    private String nome;
    private String logotipo;
    @Column(name = "data_de_criacao", insertable = false, updatable = false)
    private Date dataDeCriacao;
    @Column(name = "data_de_atualizacao", insertable = false, updatable = false)
    private Date dataDeAtualizacao;
    private String contato;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "endereco_id", referencedColumnName = "endereco_id")
    private Endereco endereco;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "imobiliaria_imovel",
            joinColumns = @JoinColumn(name = "imobiliaria_id"),
            inverseJoinColumns = @JoinColumn(name = "imovel_id"))
    private Set<Imovel> imoveis = new HashSet<>();

}
