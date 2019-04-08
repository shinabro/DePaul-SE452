alter table flights add origination_airport  long;
alter table flights add destination_airport  long;

create table airports (
    id identity not null primary key,
    code varchar(5) not null,
    city_st varchar(50) not null,
);

insert into airports(code, city_st) values ('ORD', 'Chicago, IL');
insert into airports(code, city_st) values ('DEN', 'Denver, CO');


update flights set origination_airport = (select id from airports where code = 'ORD');
update flights set destination_airport = (select id from airports where code = 'DEN');

