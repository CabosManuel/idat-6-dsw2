package com.cabos.controller;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.cabos.model.Videojuego;
import com.cabos.util.Url;

@RestController
@RequestMapping(Url.VIDEOJUEGO)
public class VideojuegoController {

	@Autowired
	private RestTemplate rt;

	@GetMapping(value = Url.LISTAR, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> listar() {
		Videojuego[] videojuegos = rt.getForObject(Url.URL_VIDEOJUEGO + Url.LISTAR, Videojuego[].class);
		Collection<Videojuego> nuevosVideojuegos = Arrays.asList(videojuegos); 
		
		return new ResponseEntity<>(nuevosVideojuegos, HttpStatus.OK);
	}
	
	@PostMapping(value = Url.AGREGAR, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> agregar(@RequestBody Videojuego videojuego){
		rt.postForLocation(Url.URL_VIDEOJUEGO + Url.AGREGAR, videojuego);
		return new ResponseEntity<>("¡Creado!", HttpStatus.CREATED);
	}
	
	@PutMapping(value = Url.EDITAR + "/{idVideojuego}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> editar(@PathVariable Integer idVideojuego, @RequestBody Videojuego videojuego){
		rt.put(Url.URL_VIDEOJUEGO + Url.EDITAR + "/" + idVideojuego, videojuego);
		return new ResponseEntity<>("¡Editado!", HttpStatus.OK);
	}
	
	@DeleteMapping(value = Url.ELIMINAR + "/{idVideojuego}")
	public ResponseEntity<?> eliminar(@PathVariable Integer idVideojuego){
		rt.delete(Url.URL_VIDEOJUEGO + Url.ELIMINAR + "/" + idVideojuego);
		return new ResponseEntity<>("¡Eliminado!", HttpStatus.OK);
	}
}
