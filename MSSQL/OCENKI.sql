CREATE DATABASE OCENKI
GO
USE OCENKI
GO

CREATE TABLE LECTURE(
ID INT IDENTITY PRIMARY KEY,  
��� NVARCHAR(50),
���� nvarchar(50),
"����" nvarchar(50),
"07.09" INT CHECK("07.09">0 AND "07.09"<2) 
);
INSERT INTO LECTURE(���,"07.09") VALUES('������ ������ ������������','������������� ��'),('����������� ��������� ����������','������ �������'),('������ ��������� �������������','�����������');



























































































DROP TABLE LECTURE;