alter table flights add arrival_date_time timestamp;

update flights
set arrival_date_time = departure_date_time + interval '2 hours'
