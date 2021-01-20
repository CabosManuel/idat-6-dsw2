package com.cabos.security.jwt;

import java.util.Collection;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import com.cabos.jwt.JWTValidator;
import com.cabos.model.jswt.JWTAuthenticationToken;
import com.cabos.model.jswt.JWTUser;
import com.cabos.model.jswt.JWTUserDetails;

public class JWTAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {

	private JWTValidator jwtValidator;
	
	@Override
	protected void additionalAuthenticationChecks(UserDetails userDetails,
			UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
	}

	@Override
	protected UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken authentication)
			throws AuthenticationException {
		JWTUserDetails userDetail=null;
		String token = ((JWTAuthenticationToken) authentication).getToken();
		
		JWTUser jwtUser = jwtValidator.validateToken(token);
		
		if (jwtUser != null) {
			
			Collection<GrantedAuthority> roles = 
					AuthorityUtils.commaSeparatedStringToAuthorityList(jwtUser.getRole());
			
			userDetail = new JWTUserDetails(
					jwtUser.getUserId(),
					jwtUser.getUsername(),
					token,
					roles);
			
			return userDetail;
		}
		
		throw new RuntimeException("Token incorrecto");
	}
	
	// metodo necesario para que funcione
	@Override
	public boolean supports(Class<?> authentication) {
		return JWTAuthenticationToken.class.isAssignableFrom(authentication);
	}
}
