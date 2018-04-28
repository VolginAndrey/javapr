use volgintest11;
go
Create table PROIZVOD(
ID int Identity,
NAMETOR nvarchar(100) primary key not null,
STRANA nvarchar(100) not null,
ZAVOD nvarchar(100) not null
);
go
Insert into PROIZVOD(NAMETOR,STRANA,ZAVOD )
values ('TOVAR1','RUS','KULTOV'),('TOVAR2','RUS','URAL'),('TOVAR4','RUS','URAL'),('TOVAR5','RUS','NOVOKUZ'),('TOVAR6','RUS','NOVOKUZ');

