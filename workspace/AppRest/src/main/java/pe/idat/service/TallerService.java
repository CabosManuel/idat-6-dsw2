package pe.idat.service;

import pe.idat.model.Taller;
import java.util.Collection;

public interface TallerService {
	void insert(Taller taller);
	void update(Taller taller);
	void delete(Integer idTaller);
	Taller findById(Integer idTaller);
	Collection<Taller> findAll();
}
