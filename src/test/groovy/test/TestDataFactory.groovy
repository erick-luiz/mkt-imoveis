package test

import com.mkt.imobiliaria.dto.EnderecoDTO
import com.mkt.imobiliaria.dto.ImobiliariaDTO
import com.mkt.imobiliaria.model.Endereco
import com.mkt.imobiliaria.model.Imagem
import com.mkt.imobiliaria.model.Imobiliaria
import com.mkt.imobiliaria.model.Imovel
import com.mkt.imobiliaria.model.TipoDeImovel
import com.mkt.imobiliaria.model.TipoDeOperacao

final class TestDataFactory {

    static criaImagem(props = null) {
        aplicaPropriedades(new Imagem(
                id: 1,
                url: "https://example.com/image1.jpg",
                dataDeAtualizacao: new Date(),
                dataDeCriacao: new Date()
        ), props)
    }

    static criaEndereco(props = null) {
        aplicaPropriedades(new Endereco(
                id: 1L,
                logradouro: "Rua Exemplo",
                numero: "123",
                complemento: "Ap 101",
                bairro: "Centro",
                cidade: "São Paulo",
                estado: "SP",
                cep: "01000-000",
                dataDeCriacao: new Date(),
                dataDeAtualizacao: new Date()
        ), props)
    }

    static criaImobiliaria(endereco, props = null) {
        aplicaPropriedades(new Imobiliaria(
                id: 1,
                nome: "Imobiliária ABC",
                logotipo: "https://example.com/logo.png",
                endereco: endereco
        ), props)
    }

    static criaImobiliariaDTO(EnderecoDTO enderecoDto) {
        new ImobiliariaDTO(
                id: 1,
                nome: "Imobiliaria ABC",
                logotipo: "https://example.com/logo.jpg",
                endereco: enderecoDto
        )
    }

    static criaEnderecoDTO() {
        EnderecoDTO enderecoDTO = new EnderecoDTO(
                id: 1,
                logradouro: "Rua Teste",
                numero: "123",
                complemento: "Apto 101",
                bairro: "Centro",
                cidade: "São Paulo",
                estado: "SP",
                cep: "01000-000",
                dataDeCriacao: new Date(),
                dataDeAtualizacao: new Date()
        )
    }

    static criaImovel(imobiliaria, imagem, endereco) {
        new Imovel(
                id: 1,
                areaConstruida: 100,
                codigo: "12345",
                precoAluguel: new BigDecimal("1500.00"),
                precoVenda: new BigDecimal("250000.00"),
                qtdBanheiros: 2,
                qtdQuartos: 3,
                qtdSuites: 1,
                qtdVagas: 2,
                tamanhoTotal: 200,
                tipoDeOperacao: TipoDeOperacao.VENDA,
                tipoImovel: TipoDeImovel.APARTAMENTO,
                dataDeCriacao: new Date(),
                dataDeAtualizacao: new Date(),
                imobiliarias: [imobiliaria] as Set<Imobiliaria>,
                imagens: [imagem] as List<Imagem>,
                endereco: endereco
        )
    }

    static <T> T aplicaPropriedades(T objeto, props = null) {
        if(props) props.each { k, v -> objeto[k] = v }
        objeto
    }
}
