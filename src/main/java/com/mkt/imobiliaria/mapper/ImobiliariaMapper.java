package com.mkt.imobiliaria.mapper;

import com.mkt.imobiliaria.dto.ImobiliariaDTO;
import com.mkt.imobiliaria.model.Imobiliaria;

public class ImobiliariaMapper {

    public static ImobiliariaDTO toDTO(Imobiliaria imobiliaria) {
        ImobiliariaDTO imobiliariaDTO = new ImobiliariaDTO();
        imobiliariaDTO.setId(imobiliaria.getId());
        imobiliariaDTO.setNome(imobiliaria.getNome());
        imobiliariaDTO.setLogotipo(imobiliaria.getLogotipo());

        if (imobiliaria.getEndereco() != null) {
            imobiliariaDTO.setEndereco(EnderecoMapper.toDTO(imobiliaria.getEndereco()));
        }

        return imobiliariaDTO;
    }

    public static Imobiliaria toEntity(ImobiliariaDTO imobiliariaDTO) {
        Imobiliaria imobiliaria = new Imobiliaria();

        imobiliaria.setNome(imobiliariaDTO.getNome());
        imobiliaria.setLogotipo(imobiliariaDTO.getLogotipo());

        if (imobiliariaDTO.getEndereco() != null) {
            imobiliaria.setEndereco(EnderecoMapper.toEntity(imobiliariaDTO.getEndereco()));
        }

        return imobiliaria;
    }

}
