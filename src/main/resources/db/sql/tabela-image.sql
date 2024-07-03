--liquibase formatted sql

--changeset elopes/IMOB-2.5 splitStatements:false runOnChange:false
--comment 1: creating the image table
CREATE TABLE IF NOT EXISTS  image (
                                image_id bigint NOT NULL,
                                imovel_id bigint NOT NULL,
                                url varchar(255),
                                created date NOT NULL DEFAULT NOW(),
                                updated date NOT NULL DEFAULT NOW(),
                                PRIMARY KEY (image_id),
                                FOREIGN KEY (imovel_id) REFERENCES imovel(imovel_id)
                        );
--rollback DROP TABLE image;

--changeset elopes/IMOB-2.6 splitStatements:false runOnChange:false
--comment 1: Trigger para atualizar a coluna "updated" na tabela "image"
CREATE TRIGGER update_image_update_trigger
BEFORE UPDATE ON imovel
FOR EACH ROW
EXECUTE FUNCTION update_updated_column();
--rollback DROP TRIGGER update_image_update_trigger;

