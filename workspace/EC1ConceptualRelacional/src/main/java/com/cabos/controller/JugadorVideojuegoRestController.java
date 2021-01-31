package com.cabos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cabos.model.Jugador;
import com.cabos.model.JugadorVideojuego;
import com.cabos.model.Videojuego;
import com.cabos.services.JugadorService;
import com.cabos.services.VideojuegoService;

@RestController
@RequestMapping("/jugador_videojuego")
public class JugadorVideojuegoRestController {
	
	@Autowired
	private JugadorService jugadorService;
	@Autowired
	private VideojuegoService videojuegoService;
	
	@PostMapping("/agregar")
	public ResponseEntity<?> agregar(@RequestBody JugadorVideojuego jugadorVideojuego){
		
		Jugador jugadorDb = jugadorService.findById(jugadorVideojuego.getJugador().getIdJugador());
		Videojuego videojuegoDb;
		
		if(jugadorDb!=null) {
			videojuegoDb = videojuegoService.findById(jugadorVideojuego.getVideojuego().getIdVideojuego());
			
			if (videojuegoDb!=null) {
				jugadorDb.addVideojuego(videojuegoDb);
				jugadorDb.setnJuegos(jugadorDb.getnJuegos()+1);
				jugadorService.insert(jugadorDb);
				
				return new ResponseEntity<>(
						"El jugador "+jugadorDb.getNombreUsuario()+" ahora tiene el juego: "+videojuegoDb.getNombre()+".",
						HttpStatus.CREATED);
			}
			
			return new ResponseEntity<>(
					"¡No existe un videjuego con ID: "+jugadorVideojuego.getVideojuego().getIdVideojuego()+"!",
					HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(
				"¡No existe un jugador con ID: "+jugadorVideojuego.getJugador().getIdJugador()+"!",
				HttpStatus.NOT_FOUND);
	}
}
