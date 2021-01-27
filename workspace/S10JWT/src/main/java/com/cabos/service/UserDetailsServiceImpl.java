package com.cabos.service;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cabos.model.Role;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserService s;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		com.cabos.model.User user = s.findByUsername(username);

		if (user != null) {
			// lista de roles
			Collection<GrantedAuthority> auths = new ArrayList<>();

			// leer los roles que tieen el obj
			for (Role role : user.getItemsRole()) {
				auths.add(new SimpleGrantedAuthority("ROLE_" + role.getType()));
			}

			// User que provee Spring org.springframework.security.core.userdetails
			return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), auths);
		}

		// return null;
		throw new UsernameNotFoundException("¡Nombre de usuario " + username + " no existe!");
	}

}
