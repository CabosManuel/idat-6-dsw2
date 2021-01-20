package com.cabos.security.jwt;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;

import com.cabos.model.jswt.JWTAuthenticationToken;
import com.cabos.util.Constant;

// clase para filtrar si el token es correcto
public class JWTAuthenticationTokenFilter extends AbstractAuthenticationProcessingFilter{
	
	public JWTAuthenticationTokenFilter() {
		super("/rest/**"); // endpoint para el filtro
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException, IOException, ServletException {
		
		String header = request.getHeader(Constant.AUTHORIZATION_HEADER);
		
		if(header != null && header.startsWith(Constant.BEARER_HEADER)) {
			String token = header.substring(7);
			JWTAuthenticationToken authenticationToken = new JWTAuthenticationToken(token);
			
			return getAuthenticationManager().authenticate(authenticationToken);
		}
		
		throw new RuntimeException("Header no existe");
		//return null;
	}
	
	@Override // metodo necesario para que funcione el attemptAuthentication() 
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {
		super.successfulAuthentication(request, response, chain, authResult);
		chain.doFilter(request, response);
	}
}
