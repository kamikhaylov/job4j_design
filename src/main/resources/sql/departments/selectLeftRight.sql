select * from emploees e left join departments d on e.departments_id = d.id;
select * from departments d right join emploees e on e.departments_id = d.id;