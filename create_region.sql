drop table if exists region.jc_region;

create table region.jc_region
(
  regionId  SERIAL PRIMARY KEY ,
  regionName varchar(255) not null
  
) ;

--set names 'utf8';

insert into region.jc_region  (regionName) values ('Brestskiy');
insert into region.jc_region  (regionName) values ('Minskiy');
insert into region.jc_region (regionName) values ('Gomelskiy');
insert into region.jc_region (regionName) values ('Vitebskiy');

