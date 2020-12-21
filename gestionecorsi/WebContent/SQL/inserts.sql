insert into articolo values(articolo_seq.nextval, 'Apple', 'Mac Pro' , 3000);
insert into articolo values(articolo_seq.nextval, 'Samsung', 's10' , 800);
insert into articolo values(articolo_seq.nextval, 'Apple', 'Air' , 3000);
insert into articolo values(articolo_seq.nextval, 'HP', 'Envy' , 1100);
insert into articolo values(articolo_seq.nextval, 'Sony', 'Vaio' , 1400);

insert into immagine values(immagine_seq.nextval, 'img/macPro.jpg', 'MAcBook Pro del 2016');
insert into immagine values(immagine_seq.nextval, 'img/s10.jpg', 'Samsung S10  del 2020');
insert into immagine values(immagine_seq.nextval, 'img/macAir.jpg', 'MAc Air');
insert into immagine values(immagine_seq.nextval, 'img/hpEnvy.jpg', 'HP Envy');
insert into immagine values(immagine_seq.nextval, 'img/sonyVaio.jpg', 'Sony VAIO');


insert into amministratore values ('admin', 'aed546a58b4ddc28fbff34a798d3c429', 'admin@test.com');

insert into ordine values(1, 2000, sysdate, 'max');

insert into utente values('max', 'rossi','via', '20010', '12-MAG-2000', 'max', 'pass', 'max@tin.it');