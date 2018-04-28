use testDB
--go
--alter table PrimaryTable add Number INT
go
insert  SecondaryTable("Name",Quantity) values ('zero', 55), ('one',2),('two',8),('tree',32);