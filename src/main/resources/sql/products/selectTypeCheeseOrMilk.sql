select p.name as Наименнование
from product as p
join type as t on p.type_id = t.id
where t.name = 'СЫР' or t.name = 'МОЛОКО';