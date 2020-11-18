package pe.idat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import pe.idat.model.Instructor;
import pe.idat.model.InstructorTecnologia;
import pe.idat.model.Tecnologia;
import pe.idat.service.InstructorService;
import pe.idat.service.TecnologiaService;

@RestController
@RequestMapping("/rest/instructor_tecnologia")
public class IntructorTecnologiaRestController {
	
	@Autowired
	private InstructorService instructorService;
	@Autowired
	private TecnologiaService tecnologiaService;
	
	@PostMapping("/agregar")
	public ResponseEntity<?> agregar(@RequestBody InstructorTecnologia instructorTecnologia){
		
		Instructor instructorDb=instructorService
				.findById(instructorTecnologia.getInstructor().getIdInstructor());
		
		if(instructorDb!=null) {
			Tecnologia tecnologiaDb=tecnologiaService
					.findById(instructorTecnologia.getTecnologia().getIdTecnologia());
			
			instructorDb.addTecnologia(tecnologiaDb);
			
			instructorService.insert(instructorDb);
			
			return new ResponseEntity<>(HttpStatus.CREATED);
		}
		
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}
