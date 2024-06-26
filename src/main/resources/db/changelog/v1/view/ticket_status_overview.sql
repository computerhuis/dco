-- liquibase formatted sql
-- changeset ronlievens:schema-1
CREATE VIEW ticket_status_overview AS
SELECT ts.*,
       e.first_name,
       e.infix,
       e.last_name
FROM ticket_status ts
         LEFT JOIN individuals e ON e.id = ts.volunteer_id;
