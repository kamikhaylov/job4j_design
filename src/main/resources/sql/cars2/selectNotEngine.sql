select e.name as Кузов from engine e
where e.id not in (
	select engine_id from car
);