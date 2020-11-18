package pe.idat.controller;

import java.util.Collection;

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

import pe.idat.model.Tecnologia;
import pe.idat.service.TecnologiaService;

@RestController
@RequestMapping("/rest/tecnologia")
public class TecnologiaRestController {
	
	@Autowired
	private TecnologiaService serv;
	
	@GetMapping("/listar")
	public ResponseEntity<?> listar() {
		Collection<Tecnologia> tecnologias = serv.findAll();
		
		if(tecnologias.isEmpty())
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			
		return new ResponseEntity<>(tecnologias,HttpStatus.OK);
	}
	
	@GetMapping("/buscar/{idTecnologia}")
	public ResponseEntity<?> buscar(@PathVariable Integer idTecnologia){
		Tecnologia tec = serv.findById(idTecnologia);
		
		if(tec!=null)
			return new ResponseEntity<>(tec,HttpStatus.OK);
		
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@PostMapping("/agregar")
	public ResponseEntity<?> agregar(@RequestBody Tecnologia tecnologia){
		serv.insert(tecnologia);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@PutMapping("/editar/{idTecnologia}")
	public ResponseEntity<?> editar(@PathVariable Integer idTecnologia,
			@RequestBody Tecnologia tecnologia){
		Tecnologia tec = serv.findById(idTecnologia);
		
		if(tec!=null) {
			tec.setNombre(tecnologia.getNombre());
			
		}
		
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	public ResponseEntity<?> elimiar(Integer idTecnologia){
		return null;
	}
}
