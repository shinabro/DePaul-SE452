/* required for uuid_generate_v4() function to generate UUID */
CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE students (
    id UUID default uuid_generate_v4 (),
    stu_id VARCHAR(10),
    nm VARCHAR(50),
    email VARCHAR(50),
    admitted_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (ID)    
);

CREATE TABLE course (
    id UUID default uuid_generate_v4 (),
    dept char(2),
    num int,
    PRIMARY KEY (ID)    
);

CREATE TABLE course_students (
    id UUID default uuid_generate_v4 (),
    course_id UUID,
    students_id UUID,
    primary key(id)        
);
