package pe.idat.service;

import pe.idat.model.Tecnologia;
import java.util.Collection;

public interface TecnologiaService {
	void insert(Tecnologia tecnologia);
	void update(Tecnologia tecnologia);
	void delete(Integer idTecnologia);
	Tecnologia findById(Integer idTecnologia);
	Collection<Tecnologia> findAll();
}
