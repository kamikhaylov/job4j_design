select p.name as Наименнование, t.name as Тип_продукта
from product as p 
join type as t on p.type_id = t.id;