--liquibase formatted sql

--changeset ericklopes:feature/MKT-IMOB-4.13 splitStatements:false runOnChange:false
--comment 1: criando a tabela de relacao entre imobiliaria e imoveis
CREATE TABLE IF NOT EXISTS imobiliaria_imovel (
    imobiliaria_id BIGINT NOT NULL,
    imovel_id BIGINT NOT NULL,
    PRIMARY KEY (imobiliaria_id, imovel_id),
    FOREIGN KEY (imobiliaria_id) REFERENCES imobiliaria(imobiliaria_id) ON DELETE CASCADE,
    FOREIGN KEY (imovel_id) REFERENCES imovel(imovel_id) ON DELETE CASCADE
);
--rollback DROP TABLE imobiliaria_imovel;