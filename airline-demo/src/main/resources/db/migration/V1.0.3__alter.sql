alter table flights add origination_airport  numeric;
alter table flights add destination_airport  numeric;

create table airports (
    id serial primary key,
    code varchar(5),
    city_st varchar(50)
);

insert into airports(code, city_st) values ('ORD', 'Chicago, IL');
insert into airports(code, city_st) values ('DEN', 'Denver, CO');


update flights set origination_airport = (select id from airports where code = 'ORD');
update flights set destination_airport = (select id from airports where code = 'DEN');
