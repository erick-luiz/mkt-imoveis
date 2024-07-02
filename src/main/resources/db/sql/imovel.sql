--liquibase formatted sql

--changeset erick-luiz:1 splitStatements:false runOnChange:false
--comment 1: creating the imovel table
CREATE TABLE IF NOT EXISTS  imovel (
                                imovel_id bigint NOT NULL,
                                origin varchar(255),
                                external_id  varchar(255),
                                price numeric,
                                created date,
                                updated date,
                                PRIMARY KEY (imovel_id)
                        );
--rollback DROP TABLE imovel;

