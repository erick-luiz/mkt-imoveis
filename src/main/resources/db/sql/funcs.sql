--liquibase formatted sql

--changeset IMOB-2.1 splitStatements:false runOnChange:false
--comment 1: creating the func para atualizar o campo update das tabelas quando houver alguma alteração
CREATE OR REPLACE FUNCTION update_updated_column()
RETURNS TRIGGER AS $$
BEGIN
    NEW.updated = NOW();
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;
--rollback DROP FUNCTION update_updated_column;