--liquibase formatted sql

--changeset elopes/IMOB-2.7 splitStatements:false runOnChange:false
--comment 1: creating the imovel table
CREATE TABLE IF NOT EXISTS  imovel (
                                imovel_id bigint NOT NULL,
                                origin varchar(255),
                                external_id  varchar(255),
                                price numeric,
                                created date NOT NULL DEFAULT NOW(),
                                updated date NOT NULL DEFAULT NOW(),
                                PRIMARY KEY (imovel_id)
                        );
--rollback DROP TABLE imovel;


--changeset elopes/IMOB-2.8 splitStatements:false runOnChange:false
--comment 1: creating the imovel table
-- Trigger para atualizar a coluna "updated" na tabela "imovel"
CREATE TRIGGER update_imovel_update_trigger
BEFORE UPDATE ON imovel
FOR EACH ROW
EXECUTE FUNCTION update_updated_column();
--rollback DROP TRIGGER update_imovel_update_trigger;

