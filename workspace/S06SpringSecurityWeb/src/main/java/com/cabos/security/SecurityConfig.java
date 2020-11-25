package com.cabos.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	// Registrar usaurios
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("cabos").password(passwordEncoder().encode("123")).roles("ESTUDIANTE");
		auth.inMemoryAuthentication().withUser("manuel").password(passwordEncoder().encode("321")).roles("ESTUDIANTE");
		auth.inMemoryAuthentication().withUser("david").password(passwordEncoder().encode("123")).roles("DOCENTE");
	}

	// Permisos http
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/", "/index").permitAll()
				// ** -> todo lo que esté a la derecha
				.antMatchers("/estudiante/**").access("hasRole('ESTUDIANTE')")
				.antMatchers("/docente/**").access("hasRole('DOCENTE')");

		http.authorizeRequests().and().formLogin();
	}

	// Enciptar contraseñas
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
