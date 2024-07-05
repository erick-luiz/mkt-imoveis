package com.mkt.imobiliaria.service;

import com.mkt.imobiliaria.model.Endereco;
import com.mkt.imobiliaria.model.Imagem;
import com.mkt.imobiliaria.model.Imobiliaria;
import com.mkt.imobiliaria.model.Imovel;
import com.mkt.imobiliaria.repository.EnderecoRepository;
import com.mkt.imobiliaria.repository.ImovelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ImovelService {

    private final ImovelRepository imovelRepository;
    private final ImobiliariaService imobiliariaService;
    private final EnderecoService enderecoService;
    private final ImagemService imagemService;

    public Page<Imovel> getAllImoveis(Pageable pageable) {
        return imovelRepository.findAll(pageable);
    }

    public Optional<Imovel> getImovelById(Long id) {
        return imovelRepository.findById(id);
    }

    public Imovel createImovel(Imovel imovel) {
        // FIMXE: Verificar doc de JPA e Hibernates pra entender melhor forma de fazer isso
        List<Imobiliaria> listOfImobiliarias = imobiliariaService.getListOfImobiliarias(
                imovel.getImobiliarias().stream()
                .map(Imobiliaria::getId).collect(Collectors.toList()));

        if(listOfImobiliarias.isEmpty()) {
            throw new IllegalStateException("Só é possivel criar imoveis para imobiliarias ja cadastradas");
        }

        imovel.setImobiliarias(Set.copyOf(listOfImobiliarias));

        Endereco enderecoSalvo = enderecoService.salvarEndereco(imovel.getEndereco());
        imovel.setEndereco(enderecoSalvo);

        List<Imagem> imagens = imovel.getImagens();
        imovel.setImagens(List.of());

        Imovel imovelSalvo = imovelRepository.saveAndFlush(imovel);
        imagens.forEach(img -> img.setImovel(imovelSalvo));

        imagemService.saveAll(imagens);
        return imovelSalvo;
    }

    public void deleteImovel(Long id) {
        imovelRepository.deleteById(id);
    }
}

