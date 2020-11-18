package pe.idat.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import pe.idat.model.Taller;
import pe.idat.service.TallerService;

@RestController
@RequestMapping("/rest/taller")
public class TallerRestController {
	
	@Autowired
	private TallerService tallerService;
	
	@GetMapping("/listar")
	public ResponseEntity<?> listar(){
		Collection<Taller> itemsTaller = tallerService.findAll();
		
		if(itemsTaller.isEmpty())
			return new ResponseEntity<>(HttpStatus.NO_CONTENT); 
		
		return new ResponseEntity<>(itemsTaller,HttpStatus.OK);
	}
	
	@GetMapping("/buscar/{idTaller}")
	public ResponseEntity<?> buscar(@PathVariable Integer idTaller){
		Taller tallerDb= tallerService.findById(idTaller);
		
		if(tallerDb!=null)
			return new ResponseEntity<>(tallerDb,HttpStatus.OK);
		
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@PostMapping("/agregar")
	public ResponseEntity<?> agregar(@RequestBody Taller taller){
		tallerService.insert(taller);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@PutMapping("/editar/{idTaller}")
	public ResponseEntity<?> editar(@PathVariable Integer idTaller, @RequestBody Taller taller){
		Taller tallerDb = tallerService.findById(idTaller);
		
		if(tallerDb!=null) {
			tallerDb.setNombre(taller.getNombre());
			tallerDb.setCreditos(taller.getCreditos());
			tallerDb.setCosto(taller.getCosto());
			tallerDb.setInstructor(taller.getInstructor());
			
			tallerService.update(tallerDb);
			return new ResponseEntity<>(tallerDb,HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	
	@DeleteMapping("/eliminar/{idTaller}")
	public ResponseEntity<?> eliminar(@PathVariable Integer idTaller){
		tallerService.delete(idTaller);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
