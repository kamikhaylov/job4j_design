select * from departments d left join emploees e on d.id = e.departments_id
where e.departments_id is null;