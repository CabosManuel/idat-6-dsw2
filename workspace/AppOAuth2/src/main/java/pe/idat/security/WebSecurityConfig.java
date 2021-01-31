package pe.idat.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import pe.idat.service.UserServiceImpl;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter
{
	@Autowired
	private UserServiceImpl userServiceImpl;
	
	@Override //autenticación
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userServiceImpl).passwordEncoder(passwordEncoder());
	}
	
	@Override //autorización
	protected void configure(HttpSecurity http) throws Exception 
	{
		http.csrf().disable()
		    .authorizeRequests()
		    .antMatchers(HttpMethod.POST,"/oauth/token").permitAll(); 
		//endpoint para obtener el token del servidor de autorizaciones
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
}
