--liquibase formatted sql

--changeset ericklopes:feature/MKT-IMOB-4.8 splitStatements:false runOnChange:false
--comment 1: criando a tabela imagem
CREATE TABLE IF NOT EXISTS  imagem (
        imagem_id bigint NOT NULL,
        data_de_atualizacao date NOT NULL DEFAULT NOW(),
        data_de_criacao date NOT NULL DEFAULT NOW(),
        imovel_id bigint NOT NULL,
        url varchar(255),
        PRIMARY KEY (imagem_id),
        FOREIGN KEY (imovel_id) REFERENCES imovel(imovel_id)
);
--rollback DROP TABLE imagem;

--changeset ericklopes:feature/MKT-IMOB-4.9 splitStatements:false runOnChange:false
--comment 1: Trigger para atualizar a coluna "data_de_atualizacao" na tabela "imagem"
CREATE TRIGGER atualiza_data_de_atualizacao_de_imagem_trigger
BEFORE UPDATE ON imagem
FOR EACH ROW
EXECUTE FUNCTION atualiza_a_coluna_data_de_atualizacao();
--rollback DROP TRIGGER atualiza_data_de_atualizacao_de_imagem_trigger;

