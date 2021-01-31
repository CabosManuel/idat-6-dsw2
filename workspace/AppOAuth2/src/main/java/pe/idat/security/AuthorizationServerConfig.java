package pe.idat.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;

import pe.idat.service.UserServiceImpl;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter
{
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private AuthenticationManager authenticationManagerBean;
	
	@Autowired
	private UserServiceImpl userServiceImpl;
	
	@Override //configurar al propietario
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception 
	{
		clients.inMemory()
		       .withClient("AppAndroid")
		       .secret(passwordEncoder.encode("android123"))
		       .authorizedGrantTypes("password","refresh_token")
		       .scopes("read","write")
		       .accessTokenValiditySeconds(1*60)
		       .refreshTokenValiditySeconds(2*60);
	}
	
	@Override //la comunicación con el propietario
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception 
	{
		endpoints.authenticationManager(authenticationManagerBean)
		         .userDetailsService(userServiceImpl);
	}
}
