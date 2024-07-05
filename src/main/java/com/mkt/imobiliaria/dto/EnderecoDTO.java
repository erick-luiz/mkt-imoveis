package com.mkt.imobiliaria.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class EnderecoDTO {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;
    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String estado;
    private String cep;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Date dataDeCriacao;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Date dataDeAtualizacao;

}
