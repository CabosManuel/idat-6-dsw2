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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cabos.model.Celular;
import com.cabos.service.CelularService;

@RestController
@RequestMapping("rest/celular")
public class CelularRestController {
	
	@Autowired
	private CelularService celularService;
	
	@GetMapping("/listar")
	public ResponseEntity<?> listar(){
		Collection<Celular> itemsCelular = celularService.findAll();
		
		if(itemsCelular.isEmpty())
			return new ResponseEntity<>(itemsCelular, HttpStatus.NO_CONTENT);
		return new ResponseEntity<>(itemsCelular,HttpStatus.OK);
	}
	
	@GetMapping("/buscar/{idCelular}")
	public ResponseEntity<?> buscar(@PathVariable Integer idCelular){
		Celular celularDb = celularService.findById(idCelular);
		
		if(celularDb!=null) 
			return new ResponseEntity<>(celularDb,HttpStatus.OK);
		
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@PostMapping("/agregar")
	public ResponseEntity<?> agregar(@RequestBody Celular celular){
		celularService.insert(celular);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@PutMapping("/editar/{idCelular}")
	public ResponseEntity<?> editar(@PathVariable Integer idCelular, @RequestBody Celular newCelular){
		Celular oldCelular = celularService.findById(idCelular);
		
		if(oldCelular!=null) {
			oldCelular.setMarca(newCelular.getMarca());
			oldCelular.setModelo(newCelular.getModelo());
			oldCelular.setPrecio(newCelular.getPrecio());
			oldCelular.setTamano(newCelular.getTamano());
			oldCelular.setPrecio(newCelular.getPrecio());
			
			celularService.update(oldCelular);
			return new ResponseEntity<>(oldCelular,HttpStatus.OK);
		}
		
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("/eliminar/{idCelular}")
	public ResponseEntity<?> eliminar(@PathVariable Integer idCelular) {
		
		if(celularService.findById(idCelular)!=null) {
			celularService.delete(idCelular);
			return new ResponseEntity<Void>(HttpStatus.OK); 
		}
		
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}
