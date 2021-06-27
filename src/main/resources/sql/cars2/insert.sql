insert into body(name) values('Седан');
insert into body(name) values('Хэтчбек');
insert into body(name) values('Универсал');
insert into body(name) values('Купе');
insert into body(name) values('Лифтбек');
insert into body(name) values('Лимузин');
insert into body(name) values('Кабриолет');
insert into body(name) values('Внедожник');

insert into engine(name) values('1.4');
insert into engine(name) values('1.6');
insert into engine(name) values('1.8');
insert into engine(name) values('2.0');
insert into engine(name) values('2.2');
insert into engine(name) values('2.4');

insert into transmission(name) values('Механическая');
insert into transmission(name) values('Автоматическая');
insert into transmission(name) values('Роботизированная');
insert into transmission(name) values('Вариативная');

insert into car(name, body_id, engine_id, transmission_id)
values('car_01', 1, 1, 1);
insert into car(name, body_id, engine_id, transmission_id)
values('car_02', 1, 1, 2);
insert into car(name, body_id, engine_id, transmission_id)
values('car_03', 1, 2, 3);
insert into car(name, body_id, engine_id, transmission_id)
values('car_04', 2, 3, 1);
insert into car(name, body_id, engine_id, transmission_id)
values('car_05', 3, 4, 2);
insert into car(name, body_id, engine_id, transmission_id)
values('car_06', 4, 5, 3);
insert into car(name, body_id, engine_id, transmission_id)
values('car_07', 5, 3, 3);
insert into car(name, body_id, engine_id, transmission_id)
values('car_08', 6, 1, 2);
insert into car(name, body_id, engine_id, transmission_id)
values('car_09', 7, 2, 2);
insert into car(name, body_id, engine_id, transmission_id)
values('car_10', 7, 5, 2);   