package com.mkt.imobiliaria.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.mkt.imobiliaria.model.Image;
import com.mkt.imobiliaria.model.Imovel;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.ReadOnlyProperty;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

@Getter
@Setter
public class ImovelDTO {
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long imovelId;
    private String origin;
    private String externalId;
    private BigDecimal price;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Date created;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Date updated;
    private Set<String> images = new HashSet<>();

    public static ImovelDTO fromEntity(Imovel imovel) {
        ImovelDTO dto = new ImovelDTO();
        dto.setImovelId(imovel.getId());
        dto.setOrigin(imovel.getOrigin());
        dto.setExternalId(imovel.getExternalId());
        dto.setPrice(imovel.getPrice());
        dto.setCreated(imovel.getCreated());
        dto.setUpdated(imovel.getUpdated());
        dto.setImages(imovel.getImages().stream().map(Image::getUrl).collect(Collectors.toSet()));
        return dto;
    }

    public Imovel toEntity() {
        Imovel imovel = new Imovel();
        imovel.setId(this.getImovelId());
        imovel.setOrigin(this.getOrigin());
        imovel.setExternalId(this.getExternalId());
        imovel.setPrice(this.getPrice());
        imovel.setImages(this.getImages().stream().map(url -> new Image(url)).collect(Collectors.toList()));
        imovel.getImages().forEach(image -> image.setImovel(imovel));
        return imovel;
    }

}

