package com.mkt.imobiliaria.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "image")
@Getter
@Setter
@NoArgsConstructor
public class Image {

    public Image(String url) {
        this.url = url;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="image_sequence")
    @SequenceGenerator(name="image_sequence", sequenceName="image_seq", allocationSize = 1)
    @Column(name = "IMAGE_ID", nullable = false)
    private Long id;

    private String url;

    @Column(name = "created", insertable = false, updatable = false)
    private Date created;

    @Column(name = "updated", insertable = false, updatable = false)
    private Date updated;

    @ManyToOne
    @JoinColumn(name = "imovel_id")
    private Imovel imovel;

}

