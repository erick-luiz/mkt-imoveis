--liquibase formatted sql

--changeset erick-luiz:1.1 splitStatements:false runOnChange:false
--comment 1: creating the image table
CREATE TABLE IF NOT EXISTS  image (
                                image_id bigint NOT NULL,
                                imovel_id bigint NOT NULL,
                                url varchar(255),
                                created date,
                                updated date,
                                PRIMARY KEY (image_id),
                                FOREIGN KEY (imovel_id) REFERENCES imovel(imovel_id)
                        );
--rollback DROP TABLE image;

