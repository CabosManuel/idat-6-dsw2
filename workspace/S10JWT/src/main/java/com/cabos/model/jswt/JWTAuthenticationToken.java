package com.cabos.model.jswt;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

// clase para guardar el token y más...
public class JWTAuthenticationToken extends UsernamePasswordAuthenticationToken {

	private static final long serialVersionUID = 1L;
	
	private String token;
	
	public JWTAuthenticationToken(String token) {
		super(null, null);
		this.token = token;
	}

	@Override
	public Object getPrincipal() {
		// null porque no es necesario, ya que se lo trabaja internamente spring
		return null;
	}
	
	@Override
	public Object getCredentials() {
		return null;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
}
