package com.cabos.security;

import java.awt.List;
import java.util.Collection;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.cabos.security.jwt.JWTAuthenticationEntryPoint;
import com.cabos.security.jwt.JWTAuthenticationProvider;
import com.cabos.security.jwt.JWTAuthenticationSuccesHandler;
import com.cabos.security.jwt.JWTAuthenticationTokenFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private JWTAuthenticationEntryPoint jwtAuthenticationEntryPoint;
	
	@Autowired
	private JWTAuthenticationProvider jwtAuthenticationProvider;
	
	@Autowired
	private JWTAuthenticationSuccesHandler jwtAuthenticationSuccesHandler;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		super.configure(auth);
		
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// AUTENTICADOS
		http.authorizeRequests()
			.antMatchers("/rest/**").authenticated();
		
		// SIN SESIÓN
		http.authorizeRequests().and()
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		
		// ERROR
		http.authorizeRequests().and()
			.exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint);
		
		// Por estar usando REST y no web (por ahora solo estamos haciendo pruebas en Insomnia)
		http.authorizeRequests().and()
			.csrf().disable();
		
		// FILTRAR SOLICITUDES DE SEGURIDAD TOKEN
		http.addFilterBefore(jwtAuthenticationTokenFilter(), UsernamePasswordAuthenticationFilter.class);
		
		// Ocultar historial?
		http.headers().cacheControl();
	}
	
	@Bean // bean que recupera la info del usuario logueado correctamente
	protected AuthenticationManager authenticationManager() {
		return new ProviderManager(Collections.singletonList(jwtAuthenticationProvider)); // se creo una lista de 1 solo elemento (el elemento es jwtAuthenticationProvider)
	}
	
	@Bean // bean filtro que extrae el token JWT de la autenticación (una correcta autenticación)
	public JWTAuthenticationTokenFilter jwtAuthenticationTokenFilter() {
		JWTAuthenticationTokenFilter filter = new JWTAuthenticationTokenFilter();
		filter.setAuthenticationManager(authenticationManager());
		filter.setAuthenticationSuccessHandler(jwtAuthenticationSuccesHandler);
		
		return filter;
	}
	
	
}
