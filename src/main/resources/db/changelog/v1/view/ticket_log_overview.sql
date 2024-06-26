-- liquibase formatted sql
-- changeset ronlievens:schema-1
CREATE VIEW ticket_log_overview AS
SELECT tl.*,
       e.first_name,
       e.infix,
       e.last_name
FROM ticket_log tl
         LEFT JOIN individuals e ON e.id = tl.volunteer_id;
