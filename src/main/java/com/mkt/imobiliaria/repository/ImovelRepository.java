package com.mkt.imobiliaria.repository;

import com.mkt.imobiliaria.model.Imovel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImovelRepository extends JpaRepository<Imovel, Long> {
}
