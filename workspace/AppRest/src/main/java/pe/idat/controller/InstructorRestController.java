package pe.idat.controller;

import java.util.Collection;

import org.apache.tomcat.util.http.fileupload.MultipartStream.ItemInputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.idat.model.Instructor;
import pe.idat.service.InstructorService;

@RestController
@RequestMapping("/rest/instructor")
public class InstructorRestController {
	
	@Autowired
	private InstructorService instructorService;
	
	@GetMapping("/listar")	
	public ResponseEntity<?> listar(){
					// ? = return generico, podría especificarse que se retornará la colleccion de instructores	
		Collection<Instructor> itemsInstructor=instructorService.findAll();
		
		if(itemsInstructor.isEmpty()) 
			return new ResponseEntity<>(itemsInstructor, HttpStatus.NO_CONTENT);
				
		return new ResponseEntity<>(itemsInstructor,HttpStatus.OK);
	}
	
	@GetMapping("/buscar/{idInstrucor}")
	public ResponseEntity<?> buscar(@PathVariable Integer idInstructor){
		Instructor instructorDb=instructorService.findById(idInstructor);
		if(instructorDb!=null)
			return new ResponseEntity<Void>(HttpStatus.OK);
		
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@PostMapping("/agregar")
	public ResponseEntity<?> agregar(@RequestBody Instructor instructor){
		instructorService.insert(instructor);		
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@PutMapping("/editar/{idInstrucor}")
	public ResponseEntity<?> editar(@PathVariable Integer idInstructor, @RequestBody Instructor newInstructor){
		Instructor oldInstructor = instructorService.findById(idInstructor);
		
		if(oldInstructor!=null) {
			oldInstructor.setNombre(newInstructor.getNombre());
			oldInstructor.setApellido(newInstructor.getApellido());
			oldInstructor.setEmail(newInstructor.getEmail());
			oldInstructor.setfContrato(newInstructor.getfContrato());
			oldInstructor.setPassword(newInstructor.getPassword());
			
			instructorService.update(oldInstructor);
			return new ResponseEntity<>(oldInstructor, HttpStatus.OK);
		}
		
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}











