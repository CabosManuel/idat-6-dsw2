package com.cabos.service;

import java.util.Collection;

import org.springframework.stereotype.Service;

import com.cabos.model.Celular;
import com.cabos.repository.CelularRepository;

@Service
public class CelularServiceImpl implements CelularService{

	private CelularRepository repository;
	
	@Override
	public void insert(Celular celular) {
		repository.save(celular);
	}

	@Override
	public void update(Celular celular) {
		repository.save(celular);
	}

	@Override
	public void delete(Integer idCelular) {
		repository.deleteById(idCelular);
	}

	@Override
	public Celular findById(Integer idCelular) {
		return repository.findById(idCelular).orElse(null);
	}

	@Override
	public Collection<Celular> findAll() {
		return (Collection<Celular>)repository.findAll();
	}
}
