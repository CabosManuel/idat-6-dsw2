package com.cabos.jwt;

import org.springframework.stereotype.Component;

import com.cabos.model.jswt.JWTUser;
import com.cabos.util.Constant;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component // para generar token
public class JWTGenerator { 
	public String generatorToken(JWTUser jwtUser) {
		String token = null;
		
		try {
			// claim por username
			Claims claims = Jwts.claims()
					.setSubject(jwtUser.getUsername()); // setSubject: asignar un username 
			
			// cargar claims
			claims.put(Constant.USER_ID, jwtUser.getUserId().toString());
			claims.put(Constant.ROLE, jwtUser.getRole());
			
			// construcción del token
			token = Jwts.builder()
					.setClaims(claims)
					.signWith(SignatureAlgorithm.HS256, Constant.KEY)
					.compact();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return token;
	}
}
