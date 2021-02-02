package com.cabos.services;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cabos.model.Rol;
import com.cabos.model.Usuario;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	private UsuarioService us;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = us.buscarPorNombreUsuario(username);
		
		if(usuario!=null) {
			// lista de roles
			Collection<GrantedAuthority> auths = new ArrayList<>();

			// leer los roles que tieen el obj
			for(Rol role:usuario.getRoles()) {
				auths.add(new SimpleGrantedAuthority("ROLE_"+role.getTipo()));
			}
			
			// User que provee Spring org.springframework.security.core.userdetails
			return new org.springframework.security.core.userdetails.User(usuario.getNomUsuario(), usuario.getPassword(), auths);
		}

		throw new UsernameNotFoundException("¡Nombre de usuario "+username+" no existe!");			
	}
}
