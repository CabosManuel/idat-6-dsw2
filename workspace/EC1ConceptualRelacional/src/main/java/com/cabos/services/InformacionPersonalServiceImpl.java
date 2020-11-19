package com.cabos.services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cabos.model.InformacionPersonal;
import com.cabos.repository.InformacionPersonalRepository;

@Service
public class InformacionPersonalServiceImpl implements InformacionPersonalService{

	@Autowired
	private InformacionPersonalRepository repository;
	
	@Override
	@Transactional
	public void insert(InformacionPersonal informacionPersonal) {
		repository.save(informacionPersonal);
	}

	@Override
	@Transactional
	public void update(InformacionPersonal informacionPersonal) {
		repository.save(informacionPersonal);
	}

	@Override
	@Transactional
	public void delete(Integer idInformacionPersonal) {
		repository.deleteById(idInformacionPersonal);
	}

	@Override
	@Transactional(readOnly = true)
	public InformacionPersonal findById(Integer idInformacionPersonal) {
		return repository.findById(idInformacionPersonal).orElse(null);
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<InformacionPersonal> findAll() {
		return (Collection<InformacionPersonal>) repository.findAll();
	}

}
