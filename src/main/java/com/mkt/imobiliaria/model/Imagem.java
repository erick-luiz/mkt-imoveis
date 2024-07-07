package com.mkt.imobiliaria.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "imagem")
@Getter
@Setter
@NoArgsConstructor
public class Imagem {

    public Imagem(String url) {
        this.url = url;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="imagem_sequence")
    @SequenceGenerator(name="imagem_sequence", sequenceName="imagem_seq", allocationSize = 1)
    @Column(name = "IMAGEM_ID", nullable = false)
    private Long id;

    private String url;

    @Column(name = "data_de_criacao", insertable = false, updatable = false)
    private Date dataDeCriacao;
    @Column(name = "data_de_atualizacao", insertable = false, updatable = false)
    private Date dataDeAtualizacao;

    @ManyToOne
    @JoinColumn(name = "imovel_id", nullable = false)
    private Imovel imovel;

}

