-- liquibase formatted sql
-- changeset ronlievens:schema-1
CREATE TABLE tickets
(
    id           BIGINT                   NOT NULL AUTO_INCREMENT,
    ticket_type  ENUM ('REPAIR', 'ISSUE') NOT NULL,
    computer_id  BIGINT,
    description  JSON,
    registered   DATETIME DEFAULT NOW()   NOT NULL,
    unregistered DATETIME,

    CONSTRAINT tickets_pk PRIMARY KEY (id),
    CONSTRAINT tickets_fk_1 FOREIGN KEY (computer_id) REFERENCES computers (id) ON UPDATE RESTRICT ON DELETE CASCADE
) ENGINE = InnoDB;
