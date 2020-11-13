package com.cabos.services;

import java.util.Collection;

import com.cabos.model.Dlc;

public interface DlcService {
	void insert(Dlc dlc);
	void update(Dlc dlc);
	void delete(Integer idDlc);
	Dlc findById(Integer idDlc);
	Collection<Dlc> findAll();
}
