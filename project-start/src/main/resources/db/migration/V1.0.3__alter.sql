alter table flights add origination_airport  long;

create table airport (
    id identity not null primary key,
    code varchar(5) not null,
    city_st varchar(50) not null,
);

insert into airport(code, city_st) values ('ORD', 'Chicago, IL');


update flights set origination_airport = (select id from airport where code = 'ORD');

