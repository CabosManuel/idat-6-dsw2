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

import com.cabos.model.InformacionPersonal;
import com.cabos.services.InformacionPersonalService;

@RestController
@RequestMapping("/rest/info_personal")
public class InformacionPersonalRestController {

	@Autowired
	private InformacionPersonalService service;

	
	@PostMapping("/agregar")
	public ResponseEntity<?> agregar(@RequestBody InformacionPersonal informacionPersonal){
		service.insert(informacionPersonal);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	

	@GetMapping("/listar")
	public ResponseEntity<?> listar(){
		Collection<InformacionPersonal> infoPersonales = service.findAll();
		
		if(infoPersonales.isEmpty())
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		
		return new ResponseEntity<>(infoPersonales,HttpStatus.OK);
	}
	
	
	@GetMapping("/buscar/{idInfoPersonal}")
	public ResponseEntity<?> buscar(@PathVariable Integer idInfoPersonal){
		InformacionPersonal infoPersonalDb = service.findById(idInfoPersonal);
		
		if(infoPersonalDb!=null)
			return new ResponseEntity<>(infoPersonalDb,HttpStatus.OK);
		
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@PutMapping("/editar/{idInfoPersonal}")
	public ResponseEntity<?> editar(@PathVariable Integer idInfoPersonal,
			@RequestBody InformacionPersonal informacionPersonal){
		
		InformacionPersonal infoPersonalDb = service.findById(idInfoPersonal);
		
		if(infoPersonalDb!=null) {
			infoPersonalDb.setApellidos(informacionPersonal.getApellidos());
			infoPersonalDb.setContrasena(informacionPersonal.getContrasena());
			infoPersonalDb.setCorreo(informacionPersonal.getCorreo());
			infoPersonalDb.setfNacimiento(informacionPersonal.getfNacimiento());
			infoPersonalDb.setNombres(informacionPersonal.getNombres());
			service.insert(infoPersonalDb);			
			
			return new ResponseEntity<>(HttpStatus.OK);
		}
		
		return new ResponseEntity<>("El código "+idInfoPersonal+"no existe",HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("/eliminar/{idInfoPersonal}")
	public ResponseEntity<?> eliminar(@PathVariable Integer idInfoPersonal){
		service.delete(idInfoPersonal);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
