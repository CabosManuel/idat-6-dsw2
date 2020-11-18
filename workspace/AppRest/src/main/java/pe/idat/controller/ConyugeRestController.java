package pe.idat.controller;

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

import pe.idat.model.Conyuge;
import pe.idat.service.ConyugeService;
import pe.idat.service.InstructorService;

@RestController
@RequestMapping("/rest/conyuge")
public class ConyugeRestController {
    
    @Autowired
    private ConyugeService conyugeService;

    @GetMapping("/listar")
    public ResponseEntity<?> listar(){
    	Collection<Conyuge> itemsConyuge = 
    			conyugeService.findAll();
    	
    	if(itemsConyuge.isEmpty())
    		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    	
    	return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @GetMapping("/buscar/{dni}")
    public ResponseEntity<?> buscar(@PathVariable Long dni){
    	Conyuge conyugeDb = conyugeService.findById(dni);
    	
    	if(conyugeDb!=null)
    		return new ResponseEntity<Void>(HttpStatus.OK);
    		
    	return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
    @PostMapping("/agregar")
    public ResponseEntity<?> agregar(@RequestBody Conyuge conyuge){
    	conyugeService.insert(conyuge);
    	
    	return new ResponseEntity<Void>(HttpStatus.CREATED);
    }
    
    @PutMapping("/editar/{dni}")
    public ResponseEntity<?> editar(@PathVariable Long dni, 
    		@RequestBody Conyuge conyuge){
    	Conyuge conyugeDb = conyugeService.findById(dni);
    	
    	if(conyugeDb!=null) {
    		conyugeDb.setNombre(conyuge.getNombre());
    		conyugeDb.setInstructor(conyuge.getInstructor());
    		
    		conyugeService.update(conyugeDb);
    		return new ResponseEntity<>(conyugeDb,
    				HttpStatus.OK);
    	}
    	return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
    @DeleteMapping("/eliminar/{dni}")
    public ResponseEntity<?> eliminar(Long dni){
    	conyugeService.delete(dni);
    	return new ResponseEntity<>(HttpStatus.OK);
    }
}
