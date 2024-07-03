--liquibase formatted sql

--changeset elopes/IMOB-2.2 splitStatements:false runOnChange:false
--comment 1: creating the hibernate sequence
    CREATE SEQUENCE hibernate_sequence START 1;
--rollback DROP SEQUENCE hibernate_sequence;

--changeset elopes/IMOB-2.3 splitStatements:false runOnChange:false
--comment Criando a sequencia para a tabela imovel
    CREATE SEQUENCE imovel_seq START 7000;
--rollback DROP SEQUENCE imovel_seq;

--changeset elopes/IMOB-2.4 splitStatements:false runOnChange:false
--comment Criando a sequencia para a tabela imagens
    CREATE SEQUENCE image_seq START 9000;
--rollback DROP SEQUENCE image_seq;
