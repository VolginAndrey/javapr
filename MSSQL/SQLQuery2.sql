use testDB
go
select IDX, Quantity, (select sum(Quantity)  from SecondaryTable AS Q where Q.Quantity=Q.Quantity)
AS AvgQ from SecondaryTable As NQ Where IDX > (select min(Quantity) from SecondaryTable)