CREATE DATABASE "volgintest5"
GO
USE "volgintest5"
CREATE TABLE "������"
("ID" INT IDENTITY ,
"���" varchar(50)PRIMARY KEY,
"O�����1" int,
"O�����2" int)
CREATE TABLE "������������"
("ID" INT IDENTITY PRIMARY KEY ,
"���" varchar(50),
"����" varchar(50),
"�/�.�" varchar(50))

GO
INSERT INTO ������(���,"O�����1","O�����2") VALUES('������ ������ ������������','2','3'),('������ ���� ����������','2','3'),('������ ��������� �������������','5','5')
,('����������� ��������� ����������','2','3'),('������� ���� ���������','2','4'),('������� ������ �������������','2','3'),('��� ����� ��������','2','3'),('������� ������ �������������','2','4')
,('�������� ������� ���������','3','5'),('����� ���� �����������','5','5'),('��������� ������ ������������','2','3'),('�������� ������ ������������','2','3'),('�������� �������� ����������','3','5'),('������ ��������� ������������','2','3');
;
INSERT INTO ������������("���","����","�/�.�") VALUES('������ ������ ������������','21.11.17','�'),('������ ������ ������������','01.12.17','�.�'),('������ ������ ������������','08.12.17','�'),
('������ ������ ������������','21.12.17','�'),('������ ������ ������������','22.12.17','�');
