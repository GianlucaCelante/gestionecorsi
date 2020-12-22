create table amministratore(
nomeadmin varchar2(30),
cognomeadmin varchar2(30),
codadmin int,
constraint p_codadmin primary key(codadmin)
)

create table corsista(
nomecorsista varchar2(30),
cognomecorsista varchar2(30),
codcorsista int,
precedentiformativi number(1),
constraint p_codcorsista primary key(codcorsista),
constraint check_bool check (precedentiformativi=1 or precedentiformativi=0)
)

create table docente(
nomedocente varchar2(30),
cognomedocente varchar2(30),
cvdocente varchar2(30),
coddocente int,
constraint p_coddocente primary key(coddocente)
)

create table corso(
codcorso int,
coddocente int,
nomecorso varchar2(30),
datainiziocorso date,
datafinecorso date,
costocorso number(7,2),
commenticorso varchar2(200),
aulacorso varchar2(30),
constraint p_codcorso primary key(codcorso),
constraint f_coddocente foreign key(coddocente) references docente(coddocente)
)

create table corso_corsista(
codcorso int,
codcorsista int,
constraint f_codcorso foreign key(codcorso) references corso(codcorso) on delete cascade,
constraint f_codcorsista foreign key(codcorsista) references corsista(codcorsista),
constraint p_cc primary key(codcorso, codcorsista)
)

create sequence corso_seq;
create sequence corsista_seq;
