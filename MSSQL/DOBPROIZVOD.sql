use volgintest11
go
ALTER TABLE Sklad add PROIZVOD nvarchar(100) Foreign key references PROIZVOD;
go
update Sklad set 
PROIZVOD='URAL' where OTDEL ='PRODUKTIVII';
update Sklad set 
PROIZVOD='NOVOKUZ' where OTDEL ='APTEKA';
update Sklad set 
PROIZVOD='KULTOV' where  OTDEL ='HOZ.TOVAR';