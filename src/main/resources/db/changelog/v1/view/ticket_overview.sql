-- liquibase formatted sql
-- changeset ronlievens:schema-1
CREATE VIEW ticket_overview AS
SELECT r.id,
       ts.status,
       r.equipment_id,
       r.ticket_type,
       r.registered,
       r.unregistered,
       r.description,
       i.first_name,
       i.infix,
       i.last_name,
       e.manufacturer,
       e.model
FROM tickets r
         LEFT JOIN equipment e ON r.equipment_id = e.id
         LEFT JOIN ticket_status ts ON r.id = ts.ticket_id
         LEFT JOIN individuals i ON i.id = ts.volunteer_id

WHERE
    date = (SELECT MAX (date) FROM ticket_status WHERE ticket_id = ts.ticket_id);
