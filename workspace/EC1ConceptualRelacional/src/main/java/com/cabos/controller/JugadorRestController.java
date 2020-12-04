package com.cabos.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cabos.mapper.JugadorMapper;
import com.cabos.mapper.MapperUtil;
import com.cabos.model.Jugador;
import com.cabos.services.JugadorService;

@RestController
@RequestMapping("/rest/jugador")
public class JugadorRestController{
	
	@Autowired
	private JugadorService service;
	
	@GetMapping("/listar")
	public ResponseEntity<?> listar(){
		Collection<Jugador> jugadores = service.findAll();
		Collection<JugadorMapper> jugadoresMapper = MapperUtil.convertCollJugadores(jugadores);
		
		if(jugadores.isEmpty()) 
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		
		return new ResponseEntity<>(jugadoresMapper,HttpStatus.OK);
	}
	
	@PostMapping("/agregar")
	public ResponseEntity<?> agregar(@RequestBody Jugador jugador){
		service.insert(jugador);
		return new ResponseEntity<>(
				"¡Jugador \""+jugador.getNombreUsuario()+"\" agregado correctamente!",
				HttpStatus.CREATED);
	}
	
	
	@GetMapping("/buscar/{idJugador}")
	public ResponseEntity<?> buscar(@PathVariable Integer idJugador){
		Jugador JugadorDb = service.findById(idJugador);
		
		if(JugadorDb!=null)
			return new ResponseEntity<>(MapperUtil.convertJugador(JugadorDb),HttpStatus.OK);
		
		return new ResponseEntity<>(
				"¡No existe jugador con ID: "+idJugador+"!",
				HttpStatus.NOT_FOUND);
	}
	
	@PutMapping("/editar/{idJugador}")
	public ResponseEntity<?> editar(@PathVariable Integer idJugador, @RequestBody Jugador newJugador){
		Jugador oldJugador = service.findById(idJugador);
		
		if(oldJugador!=null) {
			oldJugador.setNombreUsuario(newJugador.getNombreUsuario());
			oldJugador.setnJuegos(newJugador.getnJuegos());
			oldJugador.setHorasJugadas(newJugador.getHorasJugadas());
			
			service.update(oldJugador);
			return new ResponseEntity<>(MapperUtil.convertJugador(oldJugador),HttpStatus.OK);
		}
		
		return new ResponseEntity<>(
				"¡No existe jugador con ID: "+idJugador+"!",
				HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("/eliminar/{idJugador}")
	public ResponseEntity<?> eliminar(@PathVariable Integer idJugador) {
		
		if(service.findById(idJugador)!=null) {
			service.delete(idJugador);
			return new ResponseEntity<>(
					"Jugador elimnado.",
					HttpStatus.OK); 
		}
		
		return new ResponseEntity<>(
				"¡No existe jugador con ID: "+idJugador+"!",
				HttpStatus.NOT_FOUND);
	}
}
