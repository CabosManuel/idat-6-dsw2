package com.cabos.controller;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest")
public class SecurityRestController {
	
	private static Collection<Double> movimientosBancarios = new ArrayList<>();
	static {
		movimientosBancarios.add(+1000.0);
		movimientosBancarios.add(+200.0);
		movimientosBancarios.add(-500.0);
		movimientosBancarios.add(-100.0);
		movimientosBancarios.add(+400.0);
	}
	
	@GetMapping("/info_bancaria")
	public ResponseEntity<?> getInformacionBancaria(){
		
		if(!movimientosBancarios.isEmpty()) {
			return new ResponseEntity<>(movimientosBancarios, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
