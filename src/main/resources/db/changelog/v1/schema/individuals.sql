-- liquibase formatted sql
-- changeset ronlievens:schema-1
CREATE TABLE individuals
(
    id                    BIGINT                 NOT NULL AUTO_INCREMENT,
    initials              VARCHAR(255),
    first_name            VARCHAR(255)           NOT NULL,
    infix                 VARCHAR(255),
    last_name             VARCHAR(255)           NOT NULL,
    date_of_birth         DATE,

    email                 VARCHAR(255),
    mobile                CHAR(10),
    telephone             CHAR(10),

    postal_code           VARCHAR(6),
    street                VARCHAR(1024),
    house_number          INT,
    house_number_addition VARCHAR(4),
    city                  VARCHAR(1024),

    comments              TEXT,
    registered            DATETIME DEFAULT NOW() NOT NULL,
    unregistered          DATETIME,
    msaccess              JSON,
    CONSTRAINT individuals_pk PRIMARY KEY (id),
    CONSTRAINT individuals_fk_1 FOREIGN KEY (postal_code) REFERENCES postal_codes (code) ON UPDATE RESTRICT ON DELETE CASCADE
) ENGINE = InnoDB
  CHARACTER SET 'utf8'
  COLLATE 'utf8_unicode_ci';
CREATE INDEX individuals_i_1 ON individuals (postal_code);
