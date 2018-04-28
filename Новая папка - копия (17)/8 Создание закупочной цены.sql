Use bbbb;
go
ALTER TABLE "Товары" add "Закупочная" money ;
go
update Товары set
Закупочная = (цена-10)  where Закупочная is Null;

