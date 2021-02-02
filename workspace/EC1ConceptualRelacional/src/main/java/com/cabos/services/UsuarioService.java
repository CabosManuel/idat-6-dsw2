package com.cabos.services;

import com.cabos.model.Usuario;
import com.cabos.repository.UsuarioRepository;

public interface UsuarioService {

	Usuario buscarPorNombreUsuario(String username);
}
