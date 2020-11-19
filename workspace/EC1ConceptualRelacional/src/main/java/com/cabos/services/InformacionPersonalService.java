package com.cabos.services;

import java.util.Collection;

import com.cabos.model.InformacionPersonal;

public interface InformacionPersonalService {
	void insert(InformacionPersonal informacionPersonal);
	void update(InformacionPersonal informacionPersonal);
	void delete(Integer idInformacionPersonal);
	InformacionPersonal findById(Integer idInformacionPersonal);
	Collection<InformacionPersonal> findAll();
}
