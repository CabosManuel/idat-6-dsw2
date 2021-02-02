package com.cabos.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cabos.model.Usuario;
import com.cabos.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService{

	@Autowired
	private UsuarioRepository ur;
	
	@Override
	@Transactional(readOnly = true)
	public Usuario buscarPorNombreUsuario(String nomUsuario) {
		return ur.buscarPorNombreUsuario(nomUsuario);
	}
	
}
