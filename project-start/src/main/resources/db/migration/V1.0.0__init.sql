create table flights (
--    auto_increment is with mysql and H2
    id int primary key auto_increment,
--    serial is with Postgres
--    id serial primary key,
    num varchar(10),
    departure_dt timestamp default current_timestamp
);


    
