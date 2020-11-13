package com.cabos.services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cabos.model.Jugador;
import com.cabos.repository.JugadorRepository;

@Service
public class JugadorServiceImpl implements JugadorService{

	@Autowired
	private JugadorRepository repository;
	
	@Override
	public void insert(Jugador jugador) {
		repository.save(jugador);
	}

	@Override
	public void update(Jugador jugador) {
		repository.save(jugador);
	}

	@Override
	public void delete(Integer idJugador) {
		repository.deleteById(idJugador);
	}

	@Override
	public Jugador findById(Integer idJugador) {
		return repository.findById(idJugador).orElse(null);
	}

	@Override
	public Collection<Jugador> findAll() {
		return (Collection<Jugador>) repository.findAll();
	}
	
}
