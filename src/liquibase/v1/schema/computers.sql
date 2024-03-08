-- liquibase formatted sql
-- changeset ronlievens:schema-1
CREATE TABLE computers
(
    id            BIGINT                 NOT NULL AUTO_INCREMENT,
    form_factor   ENUM ('DESKTOP', 'LAPTOP'),
    status        ENUM ('CUSTOMER_PC','INCOMING_GIFT','SUITABLE_FOR_GIFT','RESERVED','GIFT_ISSUED','DEMOLITION'),
    manufacturer  VARCHAR(255)           NOT NULL,
    model         VARCHAR(255),
    specification JSON                   NOT NULL,
    customer_id BIGINT,
    registered    DATETIME DEFAULT NOW() NOT NULL,
    unregistered  DATETIME,

    CONSTRAINT computers_pk PRIMARY KEY (id),
    CONSTRAINT computers_fk_1 FOREIGN KEY (customer_id) REFERENCES individuals (id) ON UPDATE RESTRICT ON DELETE CASCADE
) ENGINE = InnoDB;
CREATE INDEX computers_i_1 ON computers (customer_id);
