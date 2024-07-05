package com.mkt.imobiliario.mapper

import com.mkt.imobiliaria.mapper.ImovelMapper
import com.mkt.imobiliaria.model.Endereco
import com.mkt.imobiliaria.model.Imagem
import com.mkt.imobiliaria.model.Imobiliaria
import spock.lang.Specification
import test.TestDataFactory

class ImovelMapperSpec extends Specification {

    def "Deve converter de Imovel para ImovelDTO"() {
        given:
        def enderecoImobiliaria = TestDataFactory.criaEndereco()
        def imobiliaria = TestDataFactory.criaImobiliaria(enderecoImobiliaria)
        def endereco = TestDataFactory.criaEndereco()
        def imagem = TestDataFactory.criaImagem()
        def imovel = TestDataFactory.criaImovel(imobiliaria, imagem, endereco)

        when:
        def imovelDTO = ImovelMapper.toDTO(imovel)

        then:
        imovelDTO.id == imovel.id
        imovelDTO.areaConstruida == imovel.areaConstruida
        imovelDTO.codigo == imovel.codigo
        imovelDTO.precoAluguel == imovel.precoAluguel
        imovelDTO.precoVenda == imovel.precoVenda
        imovelDTO.qtdBanheiros == imovel.qtdBanheiros
        imovelDTO.qtdQuartos == imovel.qtdQuartos
        imovelDTO.qtdSuites == imovel.qtdSuites
        imovelDTO.qtdVagas == imovel.qtdVagas
        imovelDTO.tamanhoTotal == imovel.tamanhoTotal
        imovelDTO.tipoDeOperacao == imovel.tipoDeOperacao.toString()
        imovelDTO.tipoImovel == imovel.tipoImovel.toString()
        imovelDTO.dataDeCriacao == imovel.dataDeCriacao
        imovelDTO.dataDeAtualizacao == imovel.dataDeAtualizacao
        imovelDTO.imobiliarias[0] == imobiliaria.id
        imovelDTO.imagens.size() == 1
        imovelDTO.imagens[0] == imagem.url
        imovelDTO.endereco.id == endereco.id
        imovelDTO.endereco.logradouro == endereco.logradouro
        imovelDTO.endereco.cidade == endereco.cidade
    }

}
