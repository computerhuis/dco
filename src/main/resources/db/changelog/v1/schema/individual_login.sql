-- liquibase formatted sql
-- changeset ronlievens:schema-0
CREATE TABLE individual_login
(
    username     VARCHAR(50)            NOT NULL,
    registered   DATETIME DEFAULT NOW() NOT NULL,
    user_type    ENUM ('SYSTEM', 'CANDIDATE', 'VOLUNTEER') NOT NULL,
    password     VARCHAR(2028),
    volunteer_id BIGINT,
    unregistered DATETIME,
    PRIMARY KEY (username),
    CONSTRAINT individual_login_fk_1 FOREIGN KEY (volunteer_id) REFERENCES individuals (id) ON UPDATE RESTRICT ON DELETE CASCADE
) ENGINE = InnoDB
  CHARACTER SET 'utf8'
  COLLATE 'utf8_unicode_ci';
