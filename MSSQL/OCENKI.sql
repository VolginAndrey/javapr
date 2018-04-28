CREATE DATABASE OCENKI
GO
USE OCENKI
GO

CREATE TABLE LECTURE(
ID INT IDENTITY PRIMARY KEY,  
ФИО NVARCHAR(50),
Тема nvarchar(50),
"ДАТА" nvarchar(50),
"07.09" INT CHECK("07.09">0 AND "07.09"<2) 
);
INSERT INTO LECTURE(ФИО,"07.09") VALUES('Волгин Андрей Владимирович','Классификация ЛС'),('Бессмельцев Александр Васильевич','Методы доступа'),('Байраз Елизавета Александровна','Коммутаторы');



























































































DROP TABLE LECTURE;