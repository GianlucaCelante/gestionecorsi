insert into docente values('Massimo', 'Rossi', 'cv', 1);
insert into docente values('Paolo', 'Verdi', 'cv', 2);
insert into docente values('Luigi', 'Bianchi', 'cv', 3);
insert into docente values('Laura', 'Neri', 'cv', 4);

insert into amministratore values('admin', 'admin', 1, 'pass');

insert into corsista values('Mario', 'Rossi', 1, 1);
insert into corsista values('Luigi', 'Verdi', 2, 0);
insert into corsista values('Paolo', 'Bianchi', 3, 1);

insert into corso values(1,1,'Informatica','20-MAG-2020','24-MAG-2021',50,'informatica','A5',15);
insert into corso values(2,4,'Java','20-GIU-2020','24-LUG-2020',50,'informatica','A1',10);

insert into corso_corsista values(1,1);
insert into corso_corsista values(1,2);
insert into corso_corsista values(1,3);
insert into corso_corsista values(2,3);