select t.name as Тип_продукта, count(p.name) as Количество
from product as p
join type as t on p.type_id = t.id
group by t.name;