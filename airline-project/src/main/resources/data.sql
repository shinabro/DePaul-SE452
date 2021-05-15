insert into flights(num, departure_date_time, arrival_date_time) values ('AA1211', '2018-04-01 20:50:00.000', '2018-04-01 22:50:00.000');
insert into flights(num, departure_date_time, arrival_date_time) values ('AA1213', '2019-05-02 20:50:00.000', '2019-05-02 22:50:00.000');
insert into flights(num, departure_date_time, arrival_date_time) values ('UA1211', '2020-06-03 20:50:00.000', '2019-05-02 22:50:00.000');

insert into airports(code, city_st) values ('ORD', 'Chicago, IL');
insert into airports(code, city_st) values ('DEN', 'Denver, CO');

update flights set origination_airport = (select id from airports where code = 'ORD');
update flights set destination_airport = (select id from airports where code = 'DEN');

-- NoSQL within Postgres
--update airports
--set reviews = '{"author": "Daniel","review": "its airport"}';

-- NoSQL within Postgres
--update flights 
--set attr = 'category => "domestic", distance => "446"';

-- Security
INSERT INTO authority(name, id) VALUES ('ROLE_ADMIN', 1);
INSERT INTO authority(name, id) VALUES ('ROLE_USER', 2);
INSERT INTO users_authority(authority_id, user_id) VALUES (1, 1);
INSERT INTO users_authority(authority_id, user_id) VALUES (2, 2);
INSERT INTO users (id, username, password) VALUES (1,'admin','$2a$10$9Qvd5OgmZ42IM/5xDiMeYOpMeGaDygACK1.yP605cie8s2bGH0QDO');
INSERT INTO users (id, username, password) VALUES (2,'user','$2a$10$9Qvd5OgmZ42IM/5xDiMeYOpMeGaDygACK1.yP605cie8s2bGH0QDO');
