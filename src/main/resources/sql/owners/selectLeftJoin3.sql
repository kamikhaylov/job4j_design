select * from devices d 
left join owners o on d.owner_id = o.id;