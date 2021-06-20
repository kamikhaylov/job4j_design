select s.name, avg(ss.mark) from students_subjects as ss join subjects s on ss.subject_id = s.id
group by s.name;