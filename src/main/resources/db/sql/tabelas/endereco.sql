--liquibase formatted sql

--changeset ericklopes:feature/MKT-IMOB-4.6 splitStatements:false runOnChange:false
--comment 1: criando a tabela endereco
CREATE TABLE IF NOT EXISTS endereco (
    endereco_id bigint PRIMARY KEY,
    logradouro VARCHAR(255) NOT NULL,
    numero VARCHAR(10),
    complemento VARCHAR(100),
    bairro VARCHAR(100),
    cidade VARCHAR(100) NOT NULL,
    estado CHAR(2) NOT NULL,
    cep CHAR(10) NOT NULL,
    data_de_atualizacao date NOT NULL DEFAULT NOW(),
    data_de_criacao date NOT NULL DEFAULT NOW()
);
--rollback DROP TABLE endereco;

--changeset ericklopes:feature/MKT-IMOB-4.7 splitStatements:false runOnChange:false
--comment 1: Trigger para atualizar a coluna "data_de_atualizacao" na tabela "endereco"
CREATE TRIGGER atualiza_data_de_atualizacao_de_endereco_trigger
BEFORE UPDATE ON endereco
FOR EACH ROW
EXECUTE FUNCTION atualiza_a_coluna_data_de_atualizacao();
--rollback DROP TRIGGER atualiza_data_de_atualizacao_de_endereco_trigger;