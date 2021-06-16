create table therapist(
	id serial primary key,
	name varchar(255)
);

create table patients(
	id serial primary key,
	name varchar(255),
	therapist_id int references therapist(id)
);