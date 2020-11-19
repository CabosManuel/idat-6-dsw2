SELECT * FROM jugadores;
SELECT * FROM informacion_personal;

SELECT concat(informacion_personal.nombres, ' ', informacion_personal.apellidos) as persona,jugadores.nombre_usuario
FROM informacion_personal,jugadores
WHERE informacion_personal.id_jugador like jugadores.id_jugador;