package com.cabos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cabos.jwt.JWTGenerator;
import com.cabos.model.Login;
import com.cabos.model.jswt.JWTUser;

// Clase que brindará el token
@RestController
@RequestMapping("/token")
public class TokenRestController {

	@Autowired
	private JWTGenerator jwtGenerator;

	@PostMapping
	public ResponseEntity<?> generate(@RequestBody Login login) {
		
		if (login.getUsername().equals("cabos") && login.getPassword().equals("c123")) {
			JWTUser jwtUser = new JWTUser();

			jwtUser.setUserId(1L);
			jwtUser.setUsername(login.getUsername());
			jwtUser.setRole("ADMIN");

			if (jwtUser != null) {
				String token = jwtGenerator.generatorToken(jwtUser);
				return new ResponseEntity<>(token, HttpStatus.OK);
			}
		}

		return new ResponseEntity<>("Error, acceso denegado.", HttpStatus.BAD_REQUEST);
	}
}
