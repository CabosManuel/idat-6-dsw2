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
@RequestMapping("/rest/jugador_videojuego")
public class JugadorVideojuegoRestController {
	
	@Autowired
	private JugadorService jugadorService;
	@Autowired
	private VideojuegoService videojuegoService;
	
	@PostMapping("/agregar")
	public ResponseEntity<?> agregar(@RequestBody JugadorVideojuego jugadorVideojuego){
		
		Jugador jugadorDb = jugadorService.findById(jugadorVideojuego.getJugador().getIdJugador());
		
		if(jugadorDb!=null) {
			Videojuego videojuegoDb = videojuegoService.findById(jugadorVideojuego.getVideojuego().getIdVideojuego());
			
			jugadorDb.addVideojuego(videojuegoDb);
			jugadorService.insert(jugadorDb);
			
			return new ResponseEntity<>(HttpStatus.CREATED);
		}
		
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}
