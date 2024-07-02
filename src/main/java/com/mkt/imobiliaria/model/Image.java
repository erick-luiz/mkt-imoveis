package com.mkt.imobiliaria.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "image")
@Getter
@Setter
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long imageId;

    private String url;
    private Date created;
    private Date updated;

    @ManyToOne
    @JoinColumn(name = "imovel_id")
    private Imovel imovel;

}

