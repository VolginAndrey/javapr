create database BBBb;
go
use BBBb;
Create table Должности(
Индекс int Identity,
Наименование nvarchar(100) primary key not null,
Оклад money not null);

Create table Сотрудники(
Индекс int Identity,
Фио nvarchar(100) primary key not null  ,
Зп money not null,
Должность nvarchar(100) Foreign key references "Должности",
constraint удаление1 foreign key (Должность) references "должности" (наименование) on delete cascade,
constraint обнова1 foreign key (Должность) references "должности" (наименование) on update cascade);

Create table Отделы(
Индекс int Identity,
"Глава отдела" nvarchar(100) Foreign key references "Сотрудники", 
Наименование nvarchar(100) primary key not null,
constraint удаление2 foreign key ("Глава отдела") references "Сотрудники" (Фио) on delete cascade,
constraint обнова2 foreign key ("Глава отдела") references "Сотрудники" (Фио) on update cascade);

Create table Товары(
Индекс int Identity primary key,
Наименование nvarchar(100) unique ,
Отдел nvarchar(100) Foreign key references "Отделы",
Цена money ,
Количество int,
constraint удаление3 foreign key (Отдел) references "Отделы" (Наименование) on delete cascade,
constraint обнова3 foreign key (Отдел) references "Отделы" (Наименование) on update cascade );

