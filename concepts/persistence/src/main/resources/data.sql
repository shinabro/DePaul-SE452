INSERT INTO students (stu_id, nm, email) VALUES 
            ('11101', 'Sheena Wyre', 'swyre0@un.org'),
            ('11100', 'Dilly Caffery', 'dcaffery1@blogspot.com'),
            ('22200', 'Marysa Alyonov', 'malyonov3@utexas.edu'),
            ('22201', 'Julie Venturoli', 'jventuroli4@marketwatch.com'),
            ('22202', 'SFrieda Liddiatt', 'fliddiatt6@yahoo.co.jp');

INSERT INTO course(dept, num) VALUES
            ('SE', 452),
            ('SE', 352);


INSERT INTO course_students(students_id) select id from students where stu_id like '111%';
UPDATE course_students set course_id = (select id from course where num=452);

INSERT INTO course_students(students_id) select id from students where stu_id like '222%';
UPDATE course_students set course_id =( select id from course where num=352) where course_id is null;