create table flights (
    id identity not null primary key,
    num varchar(10) not null,
    departure_date_time timestamp default current_timestamp,
);


    