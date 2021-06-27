select c.name as Автомобиль, b.name as Кузов, e.name as Двигатель, t.name as Коробка_передач from car c 
left join body b on c.body_id = b.id
left join engine e on c.engine_id = e.id
left join transmission t on c.transmission_id = t.id;