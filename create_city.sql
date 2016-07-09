--DROP DATABASE IF EXISTS company;
 
--CREATE DATABASE company  ENCODING 'utf8';
--DROP SCHEMA company;
--CREATE SCHEMA company;
--set schema company;
--connect company; 
drop table if exists region.jc_city;

create table region.jc_city
(
  cityId  SERIAL PRIMARY KEY ,
  cityName varchar(255) not null
  
) ;

--set names 'utf8';

insert into region.jc_city  (cityName) values ('Brest');
insert into region.jc_city  (cityName) values ('Minsk');
insert into region.jc_city (cityName) values ('Gomel');
insert into region.jc_city (cityName) values ('Vitebsk');