package com.cabos.services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cabos.model.Videojuego;
import com.cabos.repository.VideojuegoRepository;

@Service
public class VideojuegoServiceImpl implements VideojuegoService{

	@Autowired
	private VideojuegoRepository repository;
	
	@Override
	public void insert(Videojuego dlc) {
		repository.save(dlc);
	}

	@Override
	public void update(Videojuego dlc) {
		repository.save(dlc);
	}

	@Override
	public void delete(Integer idVideojuego) {
		repository.deleteById(idVideojuego);
	}

	@Override
	public Videojuego findById(Integer idVideojuego) {
		return repository.findById(idVideojuego).orElse(null);
	}

	@Override
	public Collection<Videojuego> findAll() {
		return (Collection<Videojuego>) repository.findAll();
	}
}
