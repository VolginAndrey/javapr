use bbbb;
go
Create table �����(
������ int primary key,
������������ nvarchar(100) unique ,
����� nvarchar(100) Foreign key references "������",
���� money ,
���������� int,
������������� nvarchar(100),
���������� int );
go
insert into �����(������,������������,�����,����,����������,�������������,����������)
select * From ������
where ����>(select 5*avg(����)/3 from ������)