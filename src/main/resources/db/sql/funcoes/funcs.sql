--liquibase formatted sql

--changeset ericklopes:feature/MKT-IMOB-4.1 splitStatements:false runOnChange:false
--comment 1: criando funcao para atualizar o campo data de atualizacao das tabelas quando houver alguma alteração
CREATE OR REPLACE FUNCTION atualiza_a_coluna_data_de_atualizacao()
RETURNS TRIGGER AS $$
BEGIN
    NEW.updated = NOW();
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;
--rollback DROP FUNCTION atualiza_a_coluna_data_de_atualizacao;