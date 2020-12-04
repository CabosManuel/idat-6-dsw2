use bd_dsw2_ec1;

INSERT INTO jugadores (nombre_usuario,n_juegos,horas_jugadas) VALUES ('Kboss',0,0);
INSERT INTO jugadores (nombre_usuario,n_juegos,horas_jugadas) VALUES ('Rubik',0,0);
INSERT INTO jugadores (nombre_usuario,n_juegos,horas_jugadas) VALUES ('RichMC',0,0);

INSERT INTO informacion_personal (nombres,apellidos,f_nacimiento,correo,contrasena,id_jugador) VALUES ('Manuel','Cabos','2000-06-16','manuel@gmail.com','123',3);
INSERT INTO informacion_personal (nombres,apellidos,f_nacimiento,correo,contrasena,id_jugador) VALUES ('Ignacio','Pascual','2000-06-16','ignacio@gmail.com','123',4);
INSERT INTO informacion_personal (nombres,apellidos,f_nacimiento,correo,contrasena,id_jugador) VALUES ('Ricardo','Antonio','2000-06-16','manuel@gmail.com','123',5);
/*INSERT INTO informacion_personal (nombres,apellidos,f_nacimiento,correo,contrasena,id_jugador) VALUES ('Manuel','Cabos','2000-06-16','manuel@gmail.com','123',1);
INSERT INTO informacion_personal (nombres,apellidos,f_nacimiento,correo,contrasena,id_jugador) VALUES ('Ignacio','Pascual','2000-06-16','ignacio@gmail.com','123',2);
INSERT INTO informacion_personal (nombres,apellidos,f_nacimiento,correo,contrasena,id_jugador) VALUES ('Ricardo','Antonio','2000-06-16','manuel@gmail.com','123',3);
*/

INSERT INTO videojuegos (nombre,genero,precio) VALUES ('Rocket League','Deporte',34.9);
INSERT INTO videojuegos (nombre,genero,precio) VALUES ('Enter the Gungeon','Dungeon Crawler',25.5);
INSERT INTO videojuegos (nombre,genero,precio) VALUES ('Call of Duty Advance Warfare','Shooter',159.99);
INSERT INTO videojuegos (nombre,genero,precio) VALUES ('Minecraft','Sandbox',96.25);

INSERT INTO dlc (titulo,tipo,contenido,precio,id_videojuego) VALUES ('');

SELECT * FROM jugadores;
SELECT * FROM informacion_personal;
SELECT * FROM dlc;
SELECT * FROM videojuegos;
SELECT * FROM jugadores_vieojuegos;

-- 1:1
SELECT concat(informacion_personal.nombres, ' ', informacion_personal.apellidos) as persona,jugadores.nombre_usuario
FROM informacion_personal,jugadores
WHERE informacion_personal.id_jugador like jugadores.id_jugador;

-- 1:N


-- N:M
