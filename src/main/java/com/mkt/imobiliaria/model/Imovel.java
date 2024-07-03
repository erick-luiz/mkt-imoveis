package com.mkt.imobiliaria.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

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

    private String origin;
    private String externalId;
    private BigDecimal price;

    @OneToMany(mappedBy = "imovel", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Image> images;

    @Column(name = "created", insertable = false, updatable = false)
    private Date created;
    @Column(name = "updated", insertable = false, updatable = false)
    private Date updated;

}

