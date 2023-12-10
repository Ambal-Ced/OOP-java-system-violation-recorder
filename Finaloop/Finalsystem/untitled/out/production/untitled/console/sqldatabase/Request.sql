create table request
(
Unique_ID Serial Primary Key,
Request Varchar(350)

);

insert into request (request) values ('Please Change the violence into improper uniform'),('Please Change it');

select * from request;