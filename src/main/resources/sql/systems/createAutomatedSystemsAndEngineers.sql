create table automated_systems(
	id serial primary key,
	name varchar(255)
);

create table engineers(
	id serial primary key,
	name varchar(255)
);

create table automated_systems_engineers(
	id serial primary key,
	automated_system_id int references automated_systems(id),
	engineer_id int references engineers(id)
);