package com.mkt.imobiliaria.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mkt.imobiliaria.model.Image;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class ImageDTO {
    private Long imageId;
    private String url;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Date created;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)

    private Date updated;

    public static ImageDTO fromEntity(Image image) {
        ImageDTO dto = new ImageDTO();
        dto.setImageId(image.getId());
        dto.setUrl(image.getUrl());
        dto.setCreated(image.getCreated());
        dto.setUpdated(image.getUpdated());
        return dto;
    }

    public Image toEntity() {
        return new Image(this.getUrl());
    }

}

