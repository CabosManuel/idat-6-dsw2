package pe.company.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("manuel").password("{noop}123").roles("USER");
		auth.inMemoryAuthentication().withUser("cabos").password("{noop}123").roles("USER");
		auth.inMemoryAuthentication().withUser("kboss").password("{noop}123").roles("ADMIN");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// desabilitar la protección csrf
		http.csrf().disable()
			.authorizeRequests()
			.antMatchers("/producto/listar").permitAll()
			.antMatchers("/producto/registrar").access("hasRole('USER')")
			.antMatchers("/producto/editar/**","producto/eliminar/**").access("hasRole('ADMIN')");
		
		http.authorizeRequests().and()
			.httpBasic();
	}
}
