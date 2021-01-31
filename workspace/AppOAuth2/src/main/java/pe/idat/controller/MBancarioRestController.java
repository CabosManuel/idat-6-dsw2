package pe.idat.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.idat.model.MBancario;
import pe.idat.model.User;
import pe.idat.service.MBancarioService;
import pe.idat.util.MapperUtil;

@RestController
@RequestMapping("/authorization/bank")
public class MBancarioRestController 
{
	@Autowired
	private MBancarioService mbancarioService;
	
	@GetMapping("/listar")
	public ResponseEntity<?> listar_GET(@RequestBody User user)
	{
		Collection<MBancario> itemsMBancario=mbancarioService.findAll(user.getUserId());
		
		if(!itemsMBancario.isEmpty()) {
			return new ResponseEntity<>(MapperUtil.convertMBancario(itemsMBancario),HttpStatus.OK);
		}
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
