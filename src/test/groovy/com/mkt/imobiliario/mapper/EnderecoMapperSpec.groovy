package com.mkt.imobiliario.mapper

import com.mkt.imobiliaria.mapper.EnderecoMapper
import spock.lang.Specification
import test.TestDataFactory

class EnderecoMapperSpec extends Specification {

    def "Deve converter de Endereco para EnderecoDTO e vice-versa corretamente"() {
        given:
        def endereco = TestDataFactory.criaEndereco()

        when:
        def enderecoDTO = EnderecoMapper.toDTO(endereco)
        def enderecoConvertido = EnderecoMapper.toEntity(enderecoDTO)

        then: "A conversao de endereco para dto esta correta"
        enderecoDTO.id == endereco.id
        enderecoDTO.logradouro == endereco.logradouro
        enderecoDTO.numero == endereco.numero
        enderecoDTO.complemento == endereco.complemento
        enderecoDTO.bairro == endereco.bairro
        enderecoDTO.cidade == endereco.cidade
        enderecoDTO.estado == endereco.estado
        enderecoDTO.cep == endereco.cep
        enderecoDTO.dataDeAtualizacao == endereco.dataDeAtualizacao
        enderecoDTO.dataDeCriacao == endereco.dataDeCriacao

        and: "A conversao de dto para endereco esta correta"
        enderecoConvertido.logradouro == endereco.logradouro
        enderecoConvertido.numero == endereco.numero
        enderecoConvertido.complemento == endereco.complemento
        enderecoConvertido.bairro == endereco.bairro
        enderecoConvertido.cidade == endereco.cidade
        enderecoConvertido.estado == endereco.estado
        enderecoConvertido.cep == endereco.cep
        and: "Os campos soh leitura nao sao setados"
        enderecoConvertido.id == null
        enderecoConvertido.dataDeCriacao == null
        enderecoConvertido.dataDeAtualizacao == null
    }
}
