-- m123: $2a$10$Iia/5KqJT2r3P8LTo2gF4OW//JRe7F.iZNse/nEE6ULP0YEz03Xia
-- c123: $2a$10$ayXpi7ljS7ssTEjvu9ADNOn8ARSao3/JvC3Xw6pDUb4uOU5qz8rC.

use bd_dsw2_ec1;

insert into usuario(nom_usuario,password) 
values('manuel','$2a$10$Iia/5KqJT2r3P8LTo2gF4OW//JRe7F.iZNse/nEE6ULP0YEz03Xia');

insert into usuario(nom_usuario,password) 
values('cabos','$2a$10$ayXpi7ljS7ssTEjvu9ADNOn8ARSao3/JvC3Xw6pDUb4uOU5qz8rC.');

insert into rol(tipo) values('USER');
insert into rol(tipo) values('ADMIN');

insert into usuarios_roles values(1,1);
insert into usuarios_roles values(2,2);

select * from usuario where nom_usuario = 'manuel'

select nom_usuario, password from usuario