package com.cabos.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.cabos.model.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Integer>{
	
	@Query(value = "select * from usuario where nom_usuario = ?", nativeQuery = true)
	Usuario buscarPorNombreUsuario(String nomUsuario);
}
