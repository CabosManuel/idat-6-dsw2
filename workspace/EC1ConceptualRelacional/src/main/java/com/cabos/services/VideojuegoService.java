package com.cabos.services;

import java.util.Collection;

import com.cabos.model.Videojuego;

public interface VideojuegoService {
	void insert(Videojuego videojuego);
	void update(Videojuego videojuego);
	void delete(Integer idVideojuego);
	Videojuego findById(Integer idVideojuego);
	Collection<Videojuego> findAll();
}
