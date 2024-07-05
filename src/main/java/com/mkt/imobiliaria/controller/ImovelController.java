package com.mkt.imobiliaria.controller;

import com.mkt.imobiliaria.dto.ImovelDTO;
import com.mkt.imobiliaria.mapper.ImovelMapper;
import com.mkt.imobiliaria.model.Imovel;
import com.mkt.imobiliaria.service.ImovelService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/imoveis")
@RequiredArgsConstructor
public class ImovelController {

    private final ImovelService imovelService;

    @GetMapping
    public Page<ImovelDTO> getAllImoveis(Pageable pageable) {
        return imovelService.getAllImoveis(pageable).map(ImovelMapper::toDTO);
    }

    @GetMapping("/{id}")
    public ImovelDTO getImovelById(@PathVariable Long id) {
        return imovelService.getImovelById(id).map(ImovelMapper::toDTO)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Imovel não encontrado"));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ImovelDTO createImovel(@RequestBody ImovelDTO imovelDTO) {

        Imovel imovel = imovelService.createImovel(ImovelMapper.toEntity(imovelDTO));

        return ImovelMapper.toDTO(imovel);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteImovel(@PathVariable Long id) {
        imovelService.deleteImovel(id);
    }
}

