select t.name as Коробка_передач from transmission t
where t.id not in (
	select transmission_id from car
);