-- 1 вариант
SELECT countPerson.nameCompany, countPerson.persons persons 
FROM (SELECT c.name nameCompany, COUNT(p.name) persons 
	  FROM company c
	  LEFT JOIN person p ON c.id = p.company_id
	  GROUP BY c.name) countPerson 
WHERE countPerson.persons = (SELECT MAX(countPerson.persons) 
							 FROM (SELECT c.name nameCompany, COUNT(p.name) persons 
								   FROM company c
			                       LEFT JOIN person p ON c.id = p.company_id
			                       GROUP BY c.name) countPerson)

-- 2 вариант
WITH t (nameCompany, countPerson) as (
			SELECT c.name nameCompany, COUNT(p.name) countPerson FROM company c
			LEFT JOIN person p ON c.id = p.company_id
			GROUP BY c.name)
SELECT nameCompany, countPerson FROM t
WHERE countPerson = (SELECT MAX(countPerson) FROM t)







