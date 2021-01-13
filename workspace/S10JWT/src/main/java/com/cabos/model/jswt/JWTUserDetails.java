package com.cabos.model.jswt;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class JWTUserDetails implements UserDetails {
	
	private Long userId;
	private String username;
	private String token;
	private Collection<? extends GrantedAuthority> authorities; // permisos del usuario
	
	public JWTUserDetails() {
	}
	
	public JWTUserDetails(Long userId, String username, String token,
			Collection<? extends GrantedAuthority> authorities) {
		this.userId = userId;
		this.username = username;
		this.token = token;
		this.authorities = authorities;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true; // true = no expira la cuenta...
	}

	@Override
	public boolean isAccountNonLocked() {
		return true; // true = que la cuenta no esté bloqueada...
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true; // true = que no expieren la credenciales
	}

	@Override
	public boolean isEnabled() {
		return true; 
	}

}
