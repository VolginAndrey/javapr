USE volgintest11
ALTER TABLE Sklad ADD FOREIGN KEY (OTDEL) REFERENCES OTDELS(NAZVANIE)
GO
ALTER TABLE OTDELS ADD FOREIGN KEY (MAIN) REFERENCES SOTRUDNIKI(FIO)
GO
ALTER TABLE SOTRUDNIKI ADD FOREIGN KEY ("DOLSHNOST'") REFERENCES DOLSHNOSTI("NAME")
