DROP DATABASE IF EXISTS company;
 
CREATE DATABASE company  ENCODING 'utf8';

DROP SCHEMA company;

CREATE SCHEMA company;
set schema company;
--connect company; 
create table company.jc_company
(
  order_id int  not null PRIMARY KEY,
  symbol varchar(255) not null,
  quanity int not null,
  price int not null,
  primary key (order_id)
) ;
 

--set names 'utf8';


--use company.jc_company;

insert into company.jc_company  (order_id,symbol, quanity,price) values (1,'IBM', 100, 250);
insert into company.jc_company  (order_id,symbol, quanity,price) values (2,'AAPL', 40, 100);
insert into company.jc_company (order_id,symbol, quanity,price) values (3,'MOT', 400, 50);
insert into company.jc_company (order_id,symbol, quanity,price) values (4,'ORCL', 30, 25);