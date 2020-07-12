CREATE TABLE students (
    id UUID default random_uuid(),
    stu_id VARCHAR(10),
    nm VARCHAR(50),
    email VARCHAR(50),
    admitted_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (ID)    
);

CREATE TABLE course (
    id UUID default random_uuid(),
    dept char(2),
    num int,
    PRIMARY KEY (ID)    
);

CREATE TABLE course_students (
    id UUID default random_uuid(),
    course_id UUID,
    students_id UUID,
    primary key(id)        
);
