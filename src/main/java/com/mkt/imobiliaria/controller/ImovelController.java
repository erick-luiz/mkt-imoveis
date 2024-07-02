package com.mkt.imobiliaria.controller;

import com.mkt.imobiliaria.dto.ImovelDTO;
import com.mkt.imobiliaria.model.Imovel;
import com.mkt.imobiliaria.service.ImovelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/imoveis")
public class ImovelController {
    @Autowired
    private ImovelService imovelService;

    @GetMapping
    public ResponseEntity<Page<ImovelDTO>> getAllImoveis(Pageable pageable) {
        Page<Imovel> imoveis = imovelService.getAllImoveis(pageable);
        Page<ImovelDTO> imovelDTOs = imoveis.map(ImovelDTO::fromEntity);
        return new ResponseEntity<>(imovelDTOs, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ImovelDTO> getImovelById(@PathVariable Long id) {
        Optional<Imovel> imovel = imovelService.getImovelById(id);
        return imovel.map(value -> new ResponseEntity<>(ImovelDTO.fromEntity(value), HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<ImovelDTO> createImovel(@RequestBody ImovelDTO imovelDTO) {
        Imovel imovel = imovelService.createImovel(imovelDTO.toEntity());
        return new ResponseEntity<>(ImovelDTO.fromEntity(imovel), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteImovel(@PathVariable Long id) {
        imovelService.deleteImovel(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

