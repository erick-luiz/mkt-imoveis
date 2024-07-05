package com.mkt.imobiliaria.service;

import com.mkt.imobiliaria.model.Imobiliaria;
import com.mkt.imobiliaria.repository.ImobiliariaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ImobiliariaService {
    // TODO: MKT-IMOB-5

    private final ImobiliariaRepository imobiliariaRepository;

    public List<Imobiliaria> getListOfImobiliarias(List<Long> ids) {
        return imobiliariaRepository.findAllById(ids);
    }
}
