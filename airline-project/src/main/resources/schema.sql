CREATE EXTENSION IF NOT EXISTS hstore;
DROP TABLE IF EXISTS flights;
DROP TABLE IF EXISTS airports;
DROP TABLE IF EXISTS authority;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS users_authority;

create table flights (
  id serial primary key,
  num varchar(10),
  departure_date_time timestamp default current_timestamp,
  arrival_date_time timestamp,
  origination_airport numeric,
  destination_airport numeric,
  attr hstore  
);

create table airports (
  id serial primary key,
  code varchar(5),
  city_st varchar(50),
  reviews jsonb  
);

create table authority (
    id serial primary key,
    name varchar(15)
);

create table users (
    id serial primary key,
    username varchar(15),
    password varchar(80),
    date_created timestamp default current_timestamp
);

create table users_authority (
    authority_id int,
    user_id int
);

