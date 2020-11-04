package com.cabos.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cabos.model.Celular;
import com.cabos.repository.CelularRepository;

@Service
public class CelularServiceImpl implements CelularService{

	@Autowired
	private CelularRepository repository;
	
	@Override
	@Transactional
	public void insert(Celular celular) {
		repository.save(celular);
	}

	@Override
	@Transactional
	public void update(Celular celular) {
		repository.save(celular);
	}

	@Override
	@Transactional
	public void delete(Integer idCelular) {
		repository.deleteById(idCelular);
	}

	@Override
	@Transactional(readOnly=true)
	public Celular findById(Integer idCelular) {
		return repository.findById(idCelular).orElse(null);
	}

	@Override
	@Transactional(readOnly=true)
	public Collection<Celular> findAll() {
		return (Collection<Celular>)repository.findAll();
	}
}
