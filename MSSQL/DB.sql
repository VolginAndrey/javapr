GO
create database testDB1
use testDB1
go
create table PrimaryTable(
ID INT identity primary key,
"Name" char(50),
)

create table SecondaryTable(
ID INT identity primary key,
"Name" char(50),
Quantity INT FOREIGN key REFERENCES PrimaryTable);
go
alter table PrimaryTable add Number INT
go
insert SecondaryTable values ('zero', 55), ('one',2),('two',8),('tree',32);
go
select IDX, Quantity, (select sum(Quantity)  from SecondaryTable AS Q where Q.Quantity=Q.Quantity
AS AvgQ from SecondaryTable As NQ Where IDX > (select min(Quantity) from SecondaryTable)
--go
--delete NewTabel Where Nowhere IDX >0
--go
--select * ()()()()()()()()()()()()()()()()())()()(()()()()******** into NewTabel from SecondaryTable