package com.mkt.imobiliaria.mapper;

import com.mkt.imobiliaria.dto.ImagemDTO;
import com.mkt.imobiliaria.model.Imagem;

public class ImagemMapper {

    public static ImagemDTO toDTO(Imagem imagem) {
        ImagemDTO imagemDTO = new ImagemDTO();
        imagemDTO.setId(imagem.getId());
        imagemDTO.setDataDeCriacao(imagem.getDataDeCriacao());
        imagemDTO.setDataDeAtualizacao(imagem.getDataDeAtualizacao());
        imagemDTO.setUrl(imagem.getUrl());
        return imagemDTO;
    }
}
