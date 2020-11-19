package com.cabos.services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cabos.model.Jugador;
import com.cabos.repository.JugadorRepository;

@Service
public class JugadorServiceImpl implements JugadorService{

	@Autowired
	private JugadorRepository repository;
	
	@Override
	@Transactional
	public void insert(Jugador jugador) {
		repository.save(jugador);
	}

	@Override
	@Transactional
	public void update(Jugador jugador) {
		repository.save(jugador);
	}

	@Override
	@Transactional
	public void delete(Integer idJugador) {
		repository.deleteById(idJugador);
	}

	@Override
	@Transactional(readOnly = true)
	public Jugador findById(Integer idJugador) {
		return repository.findById(idJugador).orElse(null);
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<Jugador> findAll() {
		return (Collection<Jugador>) repository.findAll();
	}
	
}
