use bbbb;
go
Create table Элита(
Индекс int primary key,
Наименование nvarchar(100) unique ,
Отдел nvarchar(100) Foreign key references "Отделы",
Цена money ,
Количество int,
Производитель nvarchar(100),
Закупочная int );
go
insert into Элита(Индекс,Наименование,Отдел,Цена,Количество,Производитель,Закупочная)
select * From Товары
where Цена>(select 5*avg(цена)/3 from Товары)