package pe.idat.service;

import java.util.Collection;

import pe.idat.model.Conyuge;

public interface ConyugeService {
	public abstract void insert(Conyuge conyuge);
	public void update(Conyuge conyuge);
	void delete(Long dni);
	Conyuge findById(Long dni);
	Collection<Conyuge> findAll();
}
