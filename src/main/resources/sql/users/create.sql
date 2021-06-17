create table role (
	id serial primary key,
	name varchar(2000)
);

create table rules (
	id serial primary key,
	name varchar(2000)
);

create table role_roles(
	id serial primary key,
	role_id int references role(id),
	rules_id int references rules(id)
);

create table users (
	id serial primary key,
	name varchar(2000),
	role_id int references role(id)
);

create table state (
	id serial primary key,
	name varchar(2000)
);

create table category (
	id serial primary key,
	name varchar(2000)
);

create table item (
	id serial primary key,
	number varchar(255),
	name varchar(2000),
	users_id int references users(id),
	category_id int references category(id),
	state_id int references state(id)
);

create table comments (
	id serial primary key,
	name varchar(2000),
	item_id int references item(id)
);

create table attachs (
	id serial primary key,
	name varchar(2000),
	item_id int references item(id)
);


















