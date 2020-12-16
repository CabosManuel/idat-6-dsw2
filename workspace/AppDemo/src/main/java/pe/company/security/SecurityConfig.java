package pe.company.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;

import pe.company.service.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private UserDetailsServiceImpl usuarios;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		// usuarios en BD
		
		//obtener toda la info usuario autenticado
		auth.userDetailsService(usuarios);
		
		/*//usuario en memoria
	 	auth.inMemoryAuthentication().withUser("manuel").password("{noop}123").roles("USER");
		auth.inMemoryAuthentication().withUser("cabos").password("{noop}123").roles("USER");
		auth.inMemoryAuthentication().withUser("kboss").password("{noop}123").roles("ADMIN");
		*/
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
			.httpBasic().and()
			
			/* POLÍTICA DE CREACIÓN PARA COOKIES
			 * cada cookie es independiente para cada usuario
			 * si no se pone, la cookie del usario anterior 
			 * se toma encuenta para en nuevo
			 */
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	}
}
