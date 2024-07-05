package com.mkt.imobiliaria.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mkt.imobiliaria.model.Endereco;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ImobiliariaDTO {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;
    private String nome;
    private String logotipo;
    private String contato;
    private EnderecoDTO endereco;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Date dataDeCriacao;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Date dataDeAtualizacao;

}
