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

import com.cabos.mapper.MapperUtil;
import com.cabos.mapper.VideojuegosMapper;
import com.cabos.model.Videojuego;
import com.cabos.services.VideojuegoService;

@RestController
@RequestMapping("/rest/videojuego")
public class VideojuegoRestController{
	
	@Autowired
	private VideojuegoService service;
	
	@GetMapping("/listar")
	public ResponseEntity<?> listar(){
		Collection<Videojuego> videojuegos = service.findAll();
		Collection<VideojuegosMapper> videojuegosMappers = MapperUtil.convertVideojuego(videojuegos);
		
		if(videojuegos.isEmpty()) 
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		
		return new ResponseEntity<>(videojuegosMappers,HttpStatus.OK);
	}
	
	@GetMapping("/buscar/{idVideojuego}")
	public ResponseEntity<?> buscar(@PathVariable Integer idVideojuego){
		Videojuego VideojuegoDb = service.findById(idVideojuego);
		
		if(VideojuegoDb!=null) 
			return new ResponseEntity<>(VideojuegoDb,HttpStatus.OK);
		
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@PostMapping("/agregar")
	public ResponseEntity<?> agregar(@RequestBody Videojuego Videojuego){
		service.insert(Videojuego);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@PutMapping("/editar/{idVideojuego}")
	public ResponseEntity<?> editar(@PathVariable Integer idVideojuego, @RequestBody Videojuego newVideojuego){
		Videojuego oldVideojuego = service.findById(idVideojuego);
		
		if(oldVideojuego!=null) {
			oldVideojuego.setNombre(newVideojuego.getNombre());
			oldVideojuego.setPrecio(newVideojuego.getPrecio());
			oldVideojuego.setGenero(newVideojuego.getGenero());
			
			
			service.update(oldVideojuego);
			return new ResponseEntity<>(oldVideojuego,HttpStatus.OK);
		}
		
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("/eliminar/{idVideojuego}")
	public ResponseEntity<?> eliminar(@PathVariable Integer idVideojuego) {
		
		if(service.findById(idVideojuego)!=null) {
			service.delete(idVideojuego);
			return new ResponseEntity<Void>(HttpStatus.OK); 
		}
		
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}
