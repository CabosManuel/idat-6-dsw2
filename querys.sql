use bd_dsw2_ec1;

delete from informacion_personal ip where ip.id_info_personal  < 100;
ALTER TABLE informacion_personal AUTO_INCREMENT = 1;

delete from jugadores_vieojuegos jv where jv.id_jugador < 100;
ALTER TABLE jugadores_vieojuegos AUTO_INCREMENT = 1;

delete from jugadores j where j.id_jugador < 100;
alter table jugadores AUTO_INCREMENT = 1;

delete from dlc d where d.id_dlc < 100;
alter table dlc AUTO_INCREMENT = 1;

delete from videojuegos v where v.id_videojuego < 100;
ALTER TABLE videojuegos AUTO_INCREMENT = 1;

/*INSERT INTO jugadores (nombre_usuario,n_juegos,horas_jugadas) VALUES ('Kboss',4,12);
INSERT INTO jugadores (nombre_usuario,n_juegos,horas_jugadas) VALUES ('RichMC',3,151);
INSERT INTO jugadores (nombre_usuario,n_juegos,horas_jugadas) VALUES ('Rubik',2,123);

INSERT INTO informacion_personal (nombres,apellidos,f_nacimiento,correo,contrasena,id_jugador) VALUES ('Manuel','Cabos','2000-06-16','manuel@gmail.com','123',1);
INSERT INTO informacion_personal (nombres,apellidos,f_nacimiento,correo,contrasena,id_jugador) VALUES ('Ricardo','Antonio','1996-01-12','ricardo@gmail.com','123',2);
INSERT INTO informacion_personal (nombres,apellidos,f_nacimiento,correo,contrasena,id_jugador) VALUES ('Ignacio','Pascual','1995-11-27','ignacio@gmail.com','123',3);
*/

INSERT INTO videojuegos (nombre,genero,precio) VALUES ('Rocket League','Deporte',34.9);
INSERT INTO videojuegos (nombre,genero,precio) VALUES ('Enter the Gungeon','Dungeon Crawler',25.5);
INSERT INTO videojuegos (nombre,genero,precio) VALUES ('Call of Duty Advance Warfare','Shooter',159.99);
INSERT INTO videojuegos (nombre,genero,precio) VALUES ('Minecraft','Sandbox',96.25);

insert into dlc (titulo,contenido,precio,tipo,id_videojuego) values (
	'Rocket League - Jurassic World Car Pack',
    '"Must go faster!" Celebrate a time when dinosaurs ruled the Earth while scoring epoch-worthy goals with the Jurassic Jeep Wrangler. Also included: themed customization items, including a T. rex Goal Explosion! ',
    9.99,
    'EN EL JUEGO',
    1);
insert into dlc (titulo,contenido,precio,tipo,id_videojuego) values (
	'Call of Duty: Advanced Warfare - Havoc Map Pack',
    'The first downloadable content pack for Call of Duty®: Advanced Warfare, featuring the all-new Exo Zombies co-op experience, the all-new versatile AE4 directed energy assault rifle, the AE4 Widowmaker custom variant.',
    40.0,
    'EN EL JUEGO',
    3);
insert into dlc (titulo,contenido,precio,tipo,id_videojuego) values (
	'Call of Duty: Advanced Warfare - Season Pass',
    'The Call of Duty: Advanced Warfare Season Pass gives you access to four exciting DLC packs* at one great price**, each delivering a collection of new, thrilling multiplayer content, bonus weapons, and more.',
    130.0,
    'EN EL JUEGO',
    3);
insert into dlc (titulo,contenido,precio,tipo,id_videojuego) values (
	'Enter the Gungeon - Soundtrack',
    'The Enter the Gungeon soundtrack by Doseone provided as high quality MP3 files.',
    20.95,
    'AUDIO',
    2);
insert into dlc (titulo,contenido,precio,tipo,id_videojuego) values (
	'Enter the Gungeon - Digital Comic',
    'Enter the Gungeon digital comic by Dayjob Studio. ',
    9.95,
    'IMGAGEN',
    2);
/*    
insert into jugadores_vieojuegos(id_jugador,id_videojuego) values (1,1);
insert into jugadores_vieojuegos(id_jugador,id_videojuego) values (1,2);
insert into jugadores_vieojuegos(id_jugador,id_videojuego) values (1,3);
insert into jugadores_vieojuegos(id_jugador,id_videojuego) values (1,4);

insert into jugadores_vieojuegos(id_jugador,id_videojuego) values (2,1);
insert into jugadores_vieojuegos(id_jugador,id_videojuego) values (2,2);
insert into jugadores_vieojuegos(id_jugador,id_videojuego) values (2,4);

insert into jugadores_vieojuegos(id_jugador,id_videojuego) values (3,1);
insert into jugadores_vieojuegos(id_jugador,id_videojuego) values (3,4);



SELECT * FROM jugadores;
SELECT * FROM informacion_personal;
SELECT * FROM videojuegos;
SELECT * FROM dlc;
SELECT * FROM jugadores_vieojuegos;

-- persona x nombre_usuario
SELECT concat(informacion_personal.nombres, ' ', informacion_personal.apellidos) as persona,jugadores.nombre_usuario
FROM informacion_personal,jugadores
WHERE informacion_personal.id_jugador like jugadores.id_jugador;
*/