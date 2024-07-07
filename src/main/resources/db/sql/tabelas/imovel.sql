--liquibase formatted sql

--changeset ericklopes:feature/MKT-IMOB-4.15 splitStatements:false runOnChange:false
--comment 1: criando a tabela imovel
CREATE TABLE IF NOT EXISTS  imovel (
    imovel_id bigint NOT NULL,
    area_construida NUMERIC,
    codigo VARCHAR(255),
    endereco_id BIGINT NOT NULL,
    preco_aluguel NUMERIC,
    preco_venda NUMERIC,
    qtd_banheiros INT DEFAULT 0,
    qtd_quartos INT DEFAULT 0,
    qtd_suites INT DEFAULT 0,
    qtd_vagas INT DEFAULT 0,
    tamanho_total NUMERIC,
    tipo_de_operacao VARCHAR(255),
    tipo_imovel VARCHAR(255),
    data_de_atualizacao date NOT NULL DEFAULT NOW(),
    data_de_criacao date NOT NULL DEFAULT NOW(),
    FOREIGN KEY (endereco_id) REFERENCES endereco(endereco_id),
    PRIMARY KEY (imovel_id)
);
--rollback DROP TABLE imovel;


--changeset ericklopes:feature/MKT-IMOB-4.16 splitStatements:false runOnChange:false
--comment 1: Trigger para atualizar a coluna "data_de_atualizacao" na tabela "imovel"
CREATE TRIGGER atualiza_data_de_atualizacao_de_imovel_trigger
BEFORE UPDATE ON imovel
FOR EACH ROW
EXECUTE FUNCTION atualiza_a_coluna_data_de_atualizacao();
--rollback DROP TRIGGER atualiza_data_de_atualizacao_de_imovel_trigger;

