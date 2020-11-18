package pe.idat.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.idat.model.Tecnologia;
import pe.idat.repository.TecnologiaRepository;

@Service
public class TecnologiaServiceImpl implements TecnologiaService{
	
	@Autowired
	private TecnologiaRepository repo;

	@Override
	@Transactional
	public void insert(Tecnologia tecnologia) {
		// TODO Auto-generated method stub
		repo.save(tecnologia);
	}

	@Override
	@Transactional
	public void update(Tecnologia tecnologia) {
		// TODO Auto-generated method stub
		repo.save(tecnologia);
	}

	@Override
	@Transactional
	public void delete(Integer idTecnologia) {
		// TODO Auto-generated method stub
		repo.deleteById(idTecnologia);
	}

	@Override
	@Transactional(readOnly=true)
	public Tecnologia findById(Integer idTecnologia) {
		// TODO Auto-generated method stub
		return repo.findById(idTecnologia).orElse(null);
	}
	
	@Override
	@Transactional(readOnly=true)
	public Collection<Tecnologia> findAll() {
		// TODO Auto-generated method stub
		return (Collection<Tecnologia>) repo.findAll();
	}
	
	
}
