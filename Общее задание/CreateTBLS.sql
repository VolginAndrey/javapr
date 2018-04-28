use testDB

create table PrimaryTable(
IDX INT identity primary key,
Name char(50)
);

create table SecondaryTable(
IDX INT identity,
Name char(50),
Quantity INTEGER foreign key references PrimaryTable
);