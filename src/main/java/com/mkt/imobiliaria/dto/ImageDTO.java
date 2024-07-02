package com.mkt.imobiliaria.dto;

import com.mkt.imobiliaria.model.Image;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class ImageDTO {
    private Long imageId;
    private String url;
    private Date created;
    private Date updated;

    public static ImageDTO fromEntity(Image image) {
        ImageDTO dto = new ImageDTO();
        dto.setImageId(image.getImageId());
        dto.setUrl(image.getUrl());
        dto.setCreated(image.getCreated());
        dto.setUpdated(image.getUpdated());
        return dto;
    }

    public Image toEntity() {
        Image image = new Image();
        image.setImageId(this.getImageId());
        image.setUrl(this.getUrl());
        image.setCreated(this.getCreated());
        image.setUpdated(this.getUpdated());
        return image;
    }

}

