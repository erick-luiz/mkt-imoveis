package com.mkt.imobiliaria.mapper;

import com.mkt.imobiliaria.dto.ImovelDTO;
import com.mkt.imobiliaria.model.Imagem;
import com.mkt.imobiliaria.model.Imobiliaria;
import com.mkt.imobiliaria.model.Imovel;
import com.mkt.imobiliaria.model.TipoDeImovel;
import com.mkt.imobiliaria.model.TipoDeOperacao;
import ma.glasnost.orika.BoundMapperFacade;
import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.MappingContext;
import ma.glasnost.orika.impl.DefaultMapperFactory;

import java.util.List;
import java.util.stream.Collectors;

public class ImovelMapper {
    public static ImovelDTO toDTO(Imovel imovel) {
        ImovelDTO imovelDTO = new ImovelDTO();
        imovelDTO.setId(imovel.getId());
        imovelDTO.setAreaConstruida(imovel.getAreaConstruida());
        imovelDTO.setCodigo(imovel.getCodigo());
        imovelDTO.setPrecoAluguel(imovel.getPrecoAluguel());
        imovelDTO.setPrecoVenda(imovel.getPrecoVenda());
        imovelDTO.setQtdBanheiros(imovel.getQtdBanheiros());
        imovelDTO.setQtdQuartos(imovel.getQtdQuartos());
        imovelDTO.setQtdSuites(imovel.getQtdSuites());
        imovelDTO.setQtdVagas(imovel.getQtdVagas());
        imovelDTO.setTamanhoTotal(imovel.getTamanhoTotal());
        imovelDTO.setTipoDeOperacao(imovel.getTipoDeOperacao().toString());
        imovelDTO.setTipoImovel(imovel.getTipoImovel().toString());
        imovelDTO.setDataDeCriacao(imovel.getDataDeCriacao());
        imovelDTO.setDataDeAtualizacao(imovel.getDataDeAtualizacao());
        imovelDTO.setImobiliarias(imovel.getImobiliarias().stream()
                .map(Imobiliaria::getId)
                .collect(Collectors.toSet()));
        imovelDTO.setImagens(mapImagesToDTO(imovel.getImagens()));
        imovelDTO.setEndereco(EnderecoMapper.toDTO(imovel.getEndereco()));
        return imovelDTO;
    }

    public static Imovel toEntity(ImovelDTO imovelDTO) {
        Imovel imovel = new Imovel();
        imovel.setId(imovelDTO.getId());
        imovel.setAreaConstruida(imovelDTO.getAreaConstruida());
        imovel.setCodigo(imovelDTO.getCodigo());
        imovel.setPrecoAluguel(imovelDTO.getPrecoAluguel());
        imovel.setPrecoVenda(imovelDTO.getPrecoVenda());
        imovel.setQtdBanheiros(imovelDTO.getQtdBanheiros());
        imovel.setQtdQuartos(imovelDTO.getQtdQuartos());
        imovel.setQtdSuites(imovelDTO.getQtdSuites());
        imovel.setQtdVagas(imovelDTO.getQtdVagas());
        imovel.setTamanhoTotal(imovelDTO.getTamanhoTotal());
        imovel.setTipoDeOperacao(TipoDeOperacao.valueOf(imovelDTO.getTipoDeOperacao()));
        imovel.setTipoImovel(TipoDeImovel.valueOf(imovelDTO.getTipoImovel()));
        imovel.setDataDeCriacao(imovelDTO.getDataDeCriacao());
        imovel.setDataDeAtualizacao(imovelDTO.getDataDeAtualizacao());
        imovel.setImobiliarias(imovelDTO.getImobiliarias().stream()
                .map(id -> {
                    Imobiliaria imobiliaria = new Imobiliaria();
                    imobiliaria.setId(id);
                    return imobiliaria;
                })
                .collect(Collectors.toSet()));
        imovel.setImagens(mapImagesToEntity(imovelDTO.getImagens()));
        imovel.setEndereco(EnderecoMapper.toEntity(imovelDTO.getEndereco()));
        return imovel;
    }

    private static List<String> mapImagesToDTO(List<Imagem> imagens) {
        return imagens.stream()
                .map(Imagem::getUrl)
                .collect(Collectors.toList());
    }

    private static List<Imagem> mapImagesToEntity(List<String> imagens) {
        return imagens.stream()
                .map(url -> new Imagem(url))
                .collect(Collectors.toList());
    }
}