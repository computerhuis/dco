-- liquibase formatted sql
-- changeset ronlievens:schema-0
CREATE TABLE individual_authorities
(
    username  VARCHAR(50) NOT NULL,
    authority VARCHAR(50) NOT NULL,
    FOREIGN KEY (username) REFERENCES individual_login (username)
) ENGINE = InnoDB
  CHARACTER SET 'utf8'
  COLLATE 'utf8_unicode_ci';

CREATE UNIQUE INDEX individual_authorities_i_1 ON individual_authorities (username, authority);
