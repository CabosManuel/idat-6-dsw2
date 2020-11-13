package com.cabos.services;

import java.util.Collection;

import com.cabos.model.Jugador;

public interface JugadorService {
	void insert(Jugador jugador);
	void update(Jugador jugador);
	void delete(Integer idJugador);
	Jugador findById(Integer idJugador);
	Collection<Jugador> findAll();
}
