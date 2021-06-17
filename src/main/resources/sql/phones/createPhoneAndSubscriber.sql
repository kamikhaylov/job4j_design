create table phone(
	id serial primary key,
	prefix varchar(5),
	number int,
	subscriber_id int references subscriber(id) unique
);

create table subscriber(
	id serial primary key,
	name varchar(255),
	phone_id int references phone(id) unique
);