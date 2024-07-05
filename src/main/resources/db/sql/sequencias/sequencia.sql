--liquibase formatted sql

--changeset ericklopes:feature/MKT-IMOB-4.2 splitStatements:false runOnChange:false
--comment Criando a sequencia para a tabela imovel
    CREATE SEQUENCE imovel_seq START 1000;
--rollback DROP SEQUENCE imovel_seq;

--changeset ericklopes:feature/MKT-IMOB-4.3 splitStatements:false runOnChange:false
--comment Criando a sequencia para a tabela imagem
    CREATE SEQUENCE imagem_seq START 2000;
--rollback DROP SEQUENCE imagem_seq;

--changeset ericklopes:feature/MKT-IMOB-4.4 splitStatements:false runOnChange:false
--comment Criando a sequencia para a tabela imobiliaria
    CREATE SEQUENCE imobiliaria_seq START 3000;
--rollback DROP SEQUENCE imobiliaria_seq;

--changeset ericklopes:feature/MKT-IMOB-4.5 splitStatements:false runOnChange:false
--comment Criando a sequencia para a tabela endereco
    CREATE SEQUENCE endereco_seq START 3000;
--rollback DROP SEQUENCE endereco_seq;
