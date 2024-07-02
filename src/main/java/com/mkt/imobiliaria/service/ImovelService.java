package com.mkt.imobiliaria.service;

import com.mkt.imobiliaria.model.Imovel;
import com.mkt.imobiliaria.repository.ImovelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ImovelService {
    @Autowired
    private ImovelRepository imovelRepository;

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

