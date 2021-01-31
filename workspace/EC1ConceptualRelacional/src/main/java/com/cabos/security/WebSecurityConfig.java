package com.cabos.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("cabos").password("{noop}c123").roles("ADMIN");
		auth.inMemoryAuthentication().withUser("manuel").password("{noop}m123").roles("USER");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
			.authorizeRequests()
				.antMatchers("/dlc/listar").authenticated()
				.antMatchers(HttpMethod.POST, "/dlc/agregar").hasRole("ADMIN")
				.antMatchers(HttpMethod.PUT, "/dlc/editar/**").hasRole("ADMIN")
				.antMatchers(HttpMethod.DELETE,"/dlc/eliminar/**").hasRole("ADMIN")
				.and().httpBasic()
				.and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	}
}
