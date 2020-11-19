SELECT * FROM jugadores;
SELECT * FROM informacion_personal;
SELECT * FROM videojuegos;
SELECT * FROM dlc;

-- 1:1
SELECT concat(informacion_personal.nombres, ' ', informacion_personal.apellidos) as persona,jugadores.nombre_usuario
FROM informacion_personal,jugadores
WHERE informacion_personal.id_jugador like jugadores.id_jugador;

-- 1:N
INSERT INTO videojuegos (nombre,genero,precio) VALUES ('Rocket League','Deporte',35.0);
INSERT INTO videojuegos (nombre,genero,precio) VALUES ('Enter the Gungeon','Dungeon Crawler',25.5);
INSERT INTO videojuegos (nombre,genero,precio) VALUES ('Call of Duty Advance Warfare','Shooter',159.99);
INSERT INTO videojuegos (nombre,genero,precio) VALUES ('Minecraft','Sandbox',96.25);
