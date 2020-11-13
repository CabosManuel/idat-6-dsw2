package com.cabos.services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cabos.model.Dlc;
import com.cabos.repository.DlcRepository;

@Service
public class DlcServiceImpl implements DlcService{

	@Autowired
	private DlcRepository repository;
	
	@Override
	public void insert(Dlc dlc) {
		repository.save(dlc);
	}

	@Override
	public void update(Dlc dlc) {
		repository.save(dlc);
	}

	@Override
	public void delete(Integer idDlc) {
		repository.deleteById(idDlc);
	}

	@Override
	public Dlc findById(Integer idDlc) {
		return repository.findById(idDlc).orElse(null);
	}

	@Override
	public Collection<Dlc> findAll() {
		return (Collection<Dlc>) repository.findAll();
	}
}
