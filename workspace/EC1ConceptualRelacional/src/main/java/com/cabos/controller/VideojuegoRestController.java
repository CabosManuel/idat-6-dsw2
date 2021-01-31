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
import com.cabos.model.Videojuego;
import com.cabos.services.VideojuegoService;

@RestController
@RequestMapping("/rest/videojuego")
public class VideojuegoRestController {

	@Autowired
	private VideojuegoService service;

	@GetMapping("/listar")
	public ResponseEntity<?> listar() {
		Collection<Videojuego> videojuegos = service.findAll();

		if (videojuegos.isEmpty())
			return new ResponseEntity<>("No hay videojuegos.", HttpStatus.NO_CONTENT);

		return new ResponseEntity<>(MapperUtil.convertCollVideojuego(videojuegos), HttpStatus.OK);
	}

	@GetMapping("/buscar/{idVideojuego}")
	public ResponseEntity<?> buscar(@PathVariable Integer idVideojuego) {
		Videojuego videojuegoDb = service.findById(idVideojuego);

		if (videojuegoDb != null)
			return new ResponseEntity<>(MapperUtil.convertVideojuegoDlcs(videojuegoDb), HttpStatus.OK);

		return new ResponseEntity<>("¡No existe un videojuego con ID: " + idVideojuego + "!", HttpStatus.NOT_FOUND);
	}

	@PostMapping("/agregar")
	public ResponseEntity<?> agregar(@RequestBody Videojuego videojuego) {
		service.insert(videojuego);
		return new ResponseEntity<>("¡Videojuego \"" + videojuego.getNombre() + "\" con ID: "
				+ videojuego.getIdVideojuego() + ", agregado correctamente!", HttpStatus.CREATED);
	}

	@PutMapping("/editar/{idVideojuego}")
	public ResponseEntity<?> editar(@PathVariable Integer idVideojuego, @RequestBody Videojuego newVideojuego) {
		Videojuego oldVideojuego = service.findById(idVideojuego);

		if (oldVideojuego != null) {
			oldVideojuego.setNombre(newVideojuego.getNombre());
			oldVideojuego.setPrecio(newVideojuego.getPrecio());
			oldVideojuego.setGenero(newVideojuego.getGenero());

			service.update(oldVideojuego);
			return new ResponseEntity<>(MapperUtil.convertVideojuego(oldVideojuego), HttpStatus.OK);
		}

		return new ResponseEntity<>("¡No existe un videojuego con ID: " + idVideojuego + "!", HttpStatus.NOT_FOUND);
	}

	@DeleteMapping("/eliminar/{idVideojuego}")
	public ResponseEntity<?> eliminar(@PathVariable Integer idVideojuego) {

		if (service.findById(idVideojuego) != null) {
			service.delete(idVideojuego);
			return new ResponseEntity<>("Videojuego eliminado", HttpStatus.OK);
		}

		return new ResponseEntity<>("¡No existe un videojuego con ID: " + idVideojuego + "!", HttpStatus.NOT_FOUND);
	}
}
