-- liquibase formatted sql
-- changeset ronlievens:schema-1
CREATE VIEW ticket_overview AS
SELECT r.id,
       ts.status,
       r.computer_id,
       r.ticket_type,
       r.registered,
       r.unregistered,
       r.description,
       e.first_name,
       e.infix,
       e.last_name,
       c.manufacturer,
       c.model
FROM tickets r
         LEFT JOIN computers c ON r.computer_id = c.id
         LEFT JOIN ticket_status ts ON r.id = ts.ticket_id
         LEFT JOIN individuals e ON e.id = ts.volunteer_id

WHERE date = (SELECT MAX(date) FROM ticket_status WHERE ticket_id = ts.ticket_id);
