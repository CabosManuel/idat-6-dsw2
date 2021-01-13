package com.cabos.jwt;

import org.springframework.stereotype.Component;

import com.cabos.model.jswt.JWTUser;
import com.cabos.util.Constant;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

@Component
public class JWTValidator {
	
	public JWTUser validateToken(String token) {
		JWTUser jwtUser = null;
		
		try {
			Claims claims = Jwts.parser()
					.setSigningKey(Constant.YOUR_SECRET)
					.parseClaimsJws(token)
					.getBody();
			
			// reconstruir la información del usuario (JWTUser)
			jwtUser = new JWTUser();
			jwtUser.setUserId(new Long(claims.get(Constant.USER_ID).toString()));
			jwtUser.setUsername(claims.getSubject());
			jwtUser.setRole(claims.get(Constant.ROLE).toString());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return jwtUser;
	}
}
