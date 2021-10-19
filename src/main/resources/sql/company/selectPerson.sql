SELECT p.name, c.name FROM person p
LEFT JOIN company c ON p.company_id = c.id
WHERE c.id != 5;