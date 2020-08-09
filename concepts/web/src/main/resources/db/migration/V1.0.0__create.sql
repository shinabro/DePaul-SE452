/* required for uuid_generate_v4() function to generate UUID */
CREATE TABLE students (
    id UUID default random_uuid (),
    stu_id VARCHAR(10),
    nm VARCHAR(50),
    email VARCHAR(50),
    admitted_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (ID)    
);
