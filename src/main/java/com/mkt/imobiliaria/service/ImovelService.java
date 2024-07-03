package com.mkt.imobiliaria.service;

import com.mkt.imobiliaria.model.Image;
import com.mkt.imobiliaria.model.Imovel;
import com.mkt.imobiliaria.repository.ImovelRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ImovelService {

    private final ImovelRepository imovelRepository;

    public ImovelService(ImovelRepository imovelRepository) {
        this.imovelRepository = imovelRepository;
    }

    public Page<Imovel> getAllImoveis(Pageable pageable) {
        return imovelRepository.findAll(pageable);
    }

    public Optional<Imovel> getImovelById(Long id) {
        return imovelRepository.findById(id);
    }

    public Imovel createImovel(Imovel imovel) {
        return imovelRepository.save(imovel);
    }

    public void deleteImovel(Long id) {
        imovelRepository.deleteById(id);
    }
}

