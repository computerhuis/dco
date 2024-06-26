-- liquibase formatted sql
-- changeset ronlievens:schema-1
CREATE VIEW volunteers_counter AS
SELECT i.*
FROM individual_login il
         LEFT JOIN individual_authorities ia ON ia.username = il.username
         LEFT JOIN individuals i ON il.volunteer_id = i.id
WHERE ia.authority = 'ROLE_COUNTER'
  AND (il.unregistered IS NULL OR il.unregistered <= CURRENT_TIME)
