insert into role(name) values ('User');
insert into role(name) values ('Admin');

insert into rules(name) values ('Reader');
insert into rules(name) values ('Writer');

insert into role_roles(role_id, rules_id) values (1, 1);
insert into role_roles(role_id, rules_id) values (2, 1);
insert into role_roles(role_id, rules_id) values (2, 2);

insert into users(name, role_id) values ('User_1', 1);
insert into users(name, role_id) values ('Admin_1', 2);

insert into state(name) values ('In work');
insert into state(name) values ('Completed');

insert into category(name) values ('Low');
insert into category(name) values ('Middle');

insert into item(number, name, users_id, category_id, state_id) values ('SD001', 'Сonsultation', 1, 1, 1);
insert into item(number, name, users_id, category_id, state_id) values ('SD002', 'Error', 1, 2, 2);

insert into comments(name, item_id) values ('Actual', 1);
insert into comments(name, item_id) values ('Thank you', 2);

insert into comments(attachs, item_id) values ('Log.txt', 2);