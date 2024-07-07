--liquibase formatted sql

--changeset ericklopes:feature/MKT-IMOB-4.11 splitStatements:false runOnChange:false
--comment 1: criando a tabela imobiliaria
CREATE TABLE IF NOT EXISTS imobiliaria (
    imobiliaria_id BIGINT NOT NULL,
    endereco_id BIGINT NOT NULL,
    logotipo VARCHAR(255),
    nome VARCHAR(255),
    contato VARCHAR(255),
    data_de_atualizacao date NOT NULL DEFAULT NOW(),
    data_de_criacao date NOT NULL DEFAULT NOW(),
    PRIMARY KEY (imobiliaria_id),
    FOREIGN KEY (endereco_id) REFERENCES endereco(endereco_id)
);
--rollback DROP TABLE imobiliaria;

--changeset ericklopes:feature/MKT-IMOB-4.12 splitStatements:false runOnChange:false
--comment 1: Trigger para atualizar a coluna "data_de_atualizacao" na tabela "imobiliaria"
CREATE TRIGGER atualiza_data_de_atualizacao_de_imobiliaria_trigger
BEFORE UPDATE ON imobiliaria
FOR EACH ROW
EXECUTE FUNCTION atualiza_a_coluna_data_de_atualizacao();
--rollback DROP TRIGGER atualiza_data_de_atualizacao_de_imobiliaria_trigger;