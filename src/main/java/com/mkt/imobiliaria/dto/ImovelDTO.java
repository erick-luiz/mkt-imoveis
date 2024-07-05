package com.mkt.imobiliaria.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.*;

@Getter
@Setter
public class ImovelDTO {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
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
    private String tipoDeOperacao;
    private String tipoImovel;
    private Date dataDeCriacao;
    private Date dataDeAtualizacao;
    private Set<Long> imobiliarias;
    private List<String> imagens;
    private EnderecoDTO endereco;

}

