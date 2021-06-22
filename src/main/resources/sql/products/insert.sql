insert into type(name) values ('МОЛОКО');
insert into type(name) values ('СЫР');
insert into type(name) values ('ВЫПЕЧКА');
insert into type(name) values ('МОРОЖЕННОЕ');

insert into product(name, type_id, expired_date, price)
values ('Сыр плавленный', 2, '2021-06-20', 220.00);
insert into product(name, type_id, expired_date, price)
values ('Сыр моцарелла', 2, '2021-06-18', 300.00);
insert into product(name, type_id, expired_date, price)
values ('Сыр косичка', 2, '2021-06-20', 180.00);

insert into product(name, type_id, expired_date, price)
values ('Молоко 25%', 1, '2021-06-17', 90.00);
insert into product(name, type_id, expired_date, price)
values ('Молоко 15%', 1, '2021-06-20', 87.00);

insert into product(name, type_id, expired_date, price)
values ('Батон горчичный', 3, '2021-06-17', 35.00);
insert into product(name, type_id, expired_date, price)
values ('Батон нарезной', 3, '2021-06-17', 40.00);
insert into product(name, type_id, expired_date, price)
values ('Городская булка', 3, '2021-06-20', 20.00);
insert into product(name, type_id, expired_date, price)
values ('Пшеничный хлеб', 3, '2021-06-19', 25.00);
insert into product(name, type_id, expired_date, price)
values ('Тостовый хлеб', 3, '2021-06-17', 50.00);
insert into product(name, type_id, expired_date, price)
values ('Булочка с изюмом', 3, '2021-06-17', 22.00);
insert into product(name, type_id, expired_date, price)
values ('Пирог вишневый', 3, '2021-06-17', 65.00);
insert into product(name, type_id, expired_date, price)
values ('Слойка', 3, '2021-06-20', 35.00);
insert into product(name, type_id, expired_date, price)
values ('Кекс', 3, '2021-06-17', 27.00);
insert into product(name, type_id, expired_date, price)
values ('Бублик', 3, '2021-06-15', 18.00);
insert into product(name, type_id, expired_date, price)
values ('Пончик', 3, '2021-06-18', 55.00);

insert into product(name, type_id, expired_date, price)
values ('Мороженное шоколадное', 4, '2021-06-18', 90.00);
insert into product(name, type_id, expired_date, price)
values ('Рожок', 4, '2021-06-20', 70.00);
insert into product(name, type_id, expired_date, price)
values ('Мороженное ванильное', 4, '2021-06-19', 70.00);