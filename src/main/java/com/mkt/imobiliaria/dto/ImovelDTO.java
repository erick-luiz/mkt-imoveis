package com.mkt.imobiliaria.dto;

import com.mkt.imobiliaria.model.Imovel;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class ImovelDTO {
    private Long imovelId;
    private String origin;
    private String externalId;
    private BigDecimal price;
    private Date created;
    private Date updated;
    private List<ImageDTO> images;

    public static ImovelDTO fromEntity(Imovel imovel) {
        ImovelDTO dto = new ImovelDTO();
        dto.setImovelId(imovel.getImovelId());
        dto.setOrigin(imovel.getOrigin());
        dto.setExternalId(imovel.getExternalId());
        dto.setPrice(imovel.getPrice());
        dto.setCreated(imovel.getCreated());
        dto.setUpdated(imovel.getUpdated());
        dto.setImages(imovel.getImages().stream().map(ImageDTO::fromEntity).collect(Collectors.toList()));
        return dto;
    }

    public Imovel toEntity() {
        Imovel imovel = new Imovel();
        imovel.setImovelId(this.getImovelId());
        imovel.setOrigin(this.getOrigin());
        imovel.setExternalId(this.getExternalId());
        imovel.setPrice(this.getPrice());
        imovel.setCreated(this.getCreated());
        imovel.setUpdated(this.getUpdated());
        imovel.setImages(this.getImages().stream().map(ImageDTO::toEntity).collect(Collectors.toList()));
        return imovel;
    }

}

