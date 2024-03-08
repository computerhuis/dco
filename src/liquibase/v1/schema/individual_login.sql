-- liquibase formatted sql
-- changeset ronlievens:schema-0
CREATE TABLE individual_login
(
    username     VARCHAR(50)                               NOT NULL,
    registered   DATETIME DEFAULT NOW()                    NOT NULL,
    user_type    ENUM ('SYSTEM', 'CANDIDATE', 'VOLUNTEER') NOT NULL,
    password     VARCHAR(2028),
    volunteer_id BIGINT,
    unregistered DATETIME,
    PRIMARY KEY (username),
    CONSTRAINT individual_login_fk_1 FOREIGN KEY (volunteer_id) REFERENCES individuals (id) ON UPDATE RESTRICT ON DELETE CASCADE
) ENGINE = InnoDB;

CREATE TABLE individual_authorities
(
    username  VARCHAR(50) NOT NULL,
    authority VARCHAR(50) NOT NULL,
    FOREIGN KEY (username) REFERENCES individual_login (username)
) ENGINE = InnoDB;

CREATE UNIQUE INDEX individual_authorities_i_1 ON individual_authorities (username, authority);
