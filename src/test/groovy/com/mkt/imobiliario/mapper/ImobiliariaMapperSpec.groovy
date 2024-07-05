package com.mkt.imobiliario.mapper

import com.mkt.imobiliaria.mapper.ImobiliariaMapper
import com.mkt.imobiliaria.model.Endereco
import spock.lang.Specification
import test.TestDataFactory

class ImobiliariaMapperSpec extends Specification {

    def "Deve converter de Imobiliaria para ImobiliariaDTO"() {
        given:
        def endereco = TestDataFactory.criaEndereco()
        def imobiliaria = TestDataFactory.criaImobiliaria(endereco)

        when:
        def imobiliariaDTO = ImobiliariaMapper.toDTO(imobiliaria)

        then:
        imobiliariaDTO.id == imobiliaria.id
        imobiliariaDTO.nome == imobiliaria.nome
        imobiliariaDTO.logotipo == imobiliaria.logotipo
        imobiliariaDTO.endereco.logradouro == imobiliaria.endereco.logradouro
        imobiliariaDTO.endereco.cidade == imobiliaria.endereco.cidade

        and: "Os campos do endereco estao corretos"
        def enderecoConvertido = imobiliariaDTO.endereco
        enderecoConvertido.logradouro == endereco.logradouro
        enderecoConvertido.numero == endereco.numero
        enderecoConvertido.complemento == endereco.complemento
        enderecoConvertido.bairro == endereco.bairro
        enderecoConvertido.cidade == endereco.cidade
        enderecoConvertido.estado == endereco.estado
        enderecoConvertido.cep == endereco.cep
        enderecoConvertido.id == endereco.id
        enderecoConvertido.dataDeCriacao == endereco.dataDeCriacao
        enderecoConvertido.dataDeAtualizacao == endereco.dataDeAtualizacao
    }

    def "Deve converter de ImobiliariaDTO para Imobiliaria"() {
        given:
        def endereco = TestDataFactory.criaEnderecoDTO()
        def imobiliariaDTO = TestDataFactory.criaImobiliariaDTO(endereco)

        when:
        def imobiliaria = ImobiliariaMapper.toEntity(imobiliariaDTO)

        then:
        imobiliaria.id == null
        imobiliaria.nome == imobiliariaDTO.nome
        imobiliaria.logotipo == imobiliariaDTO.logotipo

        and: "Os campos de endereco estao corretos"
        def enderecoConvertido = imobiliaria.endereco
        enderecoConvertido.logradouro == endereco.logradouro
        enderecoConvertido.numero == endereco.numero
        enderecoConvertido.complemento == endereco.complemento
        enderecoConvertido.bairro == endereco.bairro
        enderecoConvertido.cidade == endereco.cidade
        enderecoConvertido.estado == endereco.estado
        enderecoConvertido.cep == endereco.cep
        and: "Os campos so leitura nao sao setados"
        enderecoConvertido.id == null
        enderecoConvertido.dataDeCriacao == null
        enderecoConvertido.dataDeAtualizacao == null
    }
}
