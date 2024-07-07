package com.mkt.imobiliaria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.print.Pageable;

@RestController
@RequestMapping("/api/imobiliarias")
public class RealEstateController {
    @Autowired
    private RealEstateService realEstateService;

    @GetMapping
    public ResponseEntity<Page<RealEstateDTO>> getAllRealEstate(Pageable pageable) {
        Page<RealEstate> realEstate = realEstateService.getAllRealEstate(pageable);
        Page<RealEstateDTO> realEstateDTO = realEstate.map(RealEstateDTO::fromEntity);
        return new ResponseEntity<>(realEstateDTO, HttpStatus.OK);
    }

    @GetMapping("/{id}")

}
