package com.cabos.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

// clase para redireccionar dependiendo de quien esté logeado

@Component
public class CustomSuccessHandler extends SimpleUrlAuthenticationSuccessHandler{
	
	//objeto de redireccionamiento
	RedirectStrategy redirect = new DefaultRedirectStrategy(); 
	
	@Override
	protected void handle(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {
		
		String targetURL= determineTargetUrl(authentication);
		
		// redirigir a url que programamos
		redirect.sendRedirect(request, response, targetURL);
	}
	
	protected String determineTargetUrl(Authentication authentication) {
		String url=null;
		
		Collection<String> roles = new ArrayList<>();
		
		for(GrantedAuthority authority:authentication.getAuthorities()) {
			roles.add(authority.getAuthority());
		}
		
		if(roles.contains("ROLE_DOCENTE"))
			url="/docente";
		else if(roles.contains("ROEL_ESTUDIANTE"))
			url="/estudiante";
		else
			url="/access_denied";
		return url;
	}
	
}
