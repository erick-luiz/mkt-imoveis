package com.mkt.imobiliaria.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class ImagemDTO {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;
    private String url;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Date dataDeCriacao;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Date dataDeAtualizacao;

}

