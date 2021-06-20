select p.name, avg(d.price) from people as p 
join devices_people as dp on dp.people_id = p.id
join devices as d on dp.device_id = d.id
group by p.name
having avg(d.price) > 5000.00;