create database BBBb;
go
use BBBb;
Create table ���������(
������ int Identity,
������������ nvarchar(100) primary key not null,
����� money not null);

Create table ����������(
������ int Identity,
��� nvarchar(100) primary key not null  ,
�� money not null,
��������� nvarchar(100) Foreign key references "���������",
constraint ��������1 foreign key (���������) references "���������" (������������) on delete cascade,
constraint ������1 foreign key (���������) references "���������" (������������) on update cascade);

Create table ������(
������ int Identity,
"����� ������" nvarchar(100) Foreign key references "����������", 
������������ nvarchar(100) primary key not null,
constraint ��������2 foreign key ("����� ������") references "����������" (���) on delete cascade,
constraint ������2 foreign key ("����� ������") references "����������" (���) on update cascade);

Create table ������(
������ int Identity primary key,
������������ nvarchar(100) unique ,
����� nvarchar(100) Foreign key references "������",
���� money ,
���������� int,
constraint ��������3 foreign key (�����) references "������" (������������) on delete cascade,
constraint ������3 foreign key (�����) references "������" (������������) on update cascade );

