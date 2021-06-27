select b.name as Кузов from body b
where b.id not in (
	select body_id from car
);