INSERT INTO students (id, stu_id, nm, email) VALUES 
            (1, '11101', 'Sheena Wyre', 'swyre0@un.org'),
            (2, '11100', 'Dilly Caffery', 'dcaffery1@blogspot.com'),
            (3, '22200', 'Marysa Alyonov', 'malyonov3@utexas.edu'),
            (4, '22201', 'Julie Venturoli', 'jventuroli4@marketwatch.com'),
            (5, '22202', 'SFrieda Liddiatt', 'fliddiatt6@yahoo.co.jp');

INSERT INTO course(id, dept, num) VALUES
            (1, 'SE', 452),
            (2, 'SE', 352);


INSERT INTO course_students(course_id, students_id) VALUES 
            (1, 1),
            (1, 2),
            (1, 3),
            (2, 4),
            (2, 5);
