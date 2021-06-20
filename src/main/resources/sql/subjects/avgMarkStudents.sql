select s.name, avg(ss.mark) from students_subjects as ss join students s on ss.student_id = s.id
group by s.name;