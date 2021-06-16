insert into automated_systems(name) values ('Billing');
insert into automated_systems(name) values ('CRM');
insert into automated_systems(name) values ('Swift');

insert into engineers(name) values ('engineer_1');
insert into engineers(name) values ('engineer_2');
insert into engineers(name) values ('engineer_3');

insert into automated_systems_engineers(automated_system_id, engineer_id) values (25, 28);
insert into automated_systems_engineers(automated_system_id, engineer_id) values (25, 29);
insert into automated_systems_engineers(automated_system_id, engineer_id) values (25, 30);
insert into automated_systems_engineers(automated_system_id, engineer_id) values (26, 28);
insert into automated_systems_engineers(automated_system_id, engineer_id) values (26, 29);
insert into automated_systems_engineers(automated_system_id, engineer_id) values (27, 30);