package com.mkt.imobiliaria.service;

import com.mkt.imobiliaria.model.Imagem;
import com.mkt.imobiliaria.repository.ImagemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ImagemService {

    private final ImagemRepository imagemRepository;

    public List<Imagem> saveAll(List<Imagem> imagens) {
        return imagemRepository.saveAll(imagens);
    }
}
