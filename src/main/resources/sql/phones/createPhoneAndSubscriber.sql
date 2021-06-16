create table phone(
	id serial primary key,
	prefix varchar(5),
	number int
);

create table subscriber(
	id serial primary key,
	name varchar(255)
);

create table phone_subscriber(
	id serial primary key,
	phone_id int references phone(id) unique,
	subscriber_id int references subscriber(id) unique
);