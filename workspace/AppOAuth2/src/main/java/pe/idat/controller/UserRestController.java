package pe.idat.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.idat.model.User;
import pe.idat.service.UserService;
import pe.idat.util.MapperUtil;

@RestController
@RequestMapping("/user")
public class UserRestController 
{
	@Autowired
	private UserService userService;
	
	@GetMapping("/listar")
	public ResponseEntity<?> listar_GET()
	{
		Collection<User> itemsUser=userService.findAll();
		
		if(!itemsUser.isEmpty()) {
			return new ResponseEntity<>(MapperUtil.convertUser(itemsUser),HttpStatus.OK);
		}
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@PostMapping("/registrar")
	public ResponseEntity<?> registrar_POST(@RequestBody User user)
	{
		userService.insert(user);
		return new ResponseEntity<>("¡Username registrado!",HttpStatus.CREATED);
	}
}
