package com.cabos.service;

import java.util.Collection;

import com.cabos.model.Celular;

public interface CelularService {
	public void insert(Celular celular);
	public void update(Celular celular);
	public void delete(Integer idCelular);
	public Celular findById(Integer idCelular);
	public Collection<Celular> findAll();
}
