select IDX, Quantity, (select sum(Quantity)  from SecondaryTable AS Q where Q.Quantity=NQ.Quantity)
AS AvgQ from SecondaryTable As NQ Where IDX > (select min(Quantity) from SecondaryTable)

--Что делает?