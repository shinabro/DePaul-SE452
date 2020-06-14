-- Document based column
alter table airports add reviews jsonb;
--update airports
--set reviews = '{"author": "Daniel","review": "its airport"}';

-- Key value
alter table flights add attr hstore;

--update flights 
--set attr = 'category => "domestic", distance => "446"';
