package com.mkt.imobiliario.mapper

import com.mkt.imobiliaria.mapper.ImagemMapper
import spock.lang.Specification
import test.TestDataFactory

class ImagemMapperSpec extends Specification {

    def "Deve converter de imagem para imagem DTO"() {
        given:
        def imagem = TestDataFactory.criaImagem()

        when:
        def imagemDTO = ImagemMapper.toDTO(imagem)

        then: "Os dados não são nulos"
        imagemDTO.id != null
        imagemDTO.url != null
        imagemDTO.dataDeAtualizacao != null
        imagemDTO.dataDeCriacao != null

        and: "Os dados são iaguais aos do objeto de origem"
        imagemDTO.id == imagem.id
        imagemDTO.url == imagem.url
        imagemDTO.dataDeAtualizacao == imagem.dataDeAtualizacao
        imagemDTO.dataDeCriacao == imagem.dataDeCriacao
    }
}
