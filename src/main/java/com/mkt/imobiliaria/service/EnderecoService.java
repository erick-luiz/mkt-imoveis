package com.mkt.imobiliaria.service;

import com.mkt.imobiliaria.model.Endereco;
import com.mkt.imobiliaria.repository.EnderecoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EnderecoService {

    private final EnderecoRepository enderecoRepository;

    public Endereco salvarEndereco(Endereco endereco) {
        return enderecoRepository.saveAndFlush(endereco);
    }
}
