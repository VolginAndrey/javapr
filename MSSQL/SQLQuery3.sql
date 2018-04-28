--create database testDB
use testDB
go
create table PrimaryTable(
ID INT identity primary key,
Name char(50),
)

create table SecondaryTable(
ID INT identity primary key,
"Name" char(50),
Quantity INT FOREIGN key REFERENCES PrimaryTable);