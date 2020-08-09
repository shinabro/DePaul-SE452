create table flights (
    id serial primary key,
    num varchar(10),
    departure_date_time timestamp default current_timestamp
);


    