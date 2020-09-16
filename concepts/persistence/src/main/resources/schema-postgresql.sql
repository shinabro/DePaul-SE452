DROP TABLE IF EXISTS course_students;
DROP TABLE IF EXISTS students;
DROP TABLE IF EXISTS course;
DROP SEQUENCE IF EXISTS hibernate_sequence;

CREATE SEQUENCE hibernate_sequence START WITH 100 INCREMENT BY 1;

CREATE TABLE students (
    id serial  PRIMARY KEY,
    stu_id VARCHAR(10),
    nm VARCHAR(50),
    email VARCHAR(50),
    admitted_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE course (
    id serial  PRIMARY KEY,
    dept char(2),
    num int
);

CREATE TABLE course_students (
     id serial  PRIMARY KEY,
    course_id int,
    students_id int       
);
