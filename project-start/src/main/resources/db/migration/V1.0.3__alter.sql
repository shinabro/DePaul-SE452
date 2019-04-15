alter table flights add origination_airport  long;
alter table flights add destination_airport  long;

create table airports (
    id int primary key auto_increment,
    code varchar(5),
    city_st varchar(50)
);

insert into airports(code, city_st) values ('ORD', 'Chicago, IL');
insert into airports(code, city_st) values ('DEN', 'Denver, CO');


update flights set origination_airport = (select id from airports where code = 'ORD');
update flights set destination_airport = (select id from airports where code = 'DEN');

