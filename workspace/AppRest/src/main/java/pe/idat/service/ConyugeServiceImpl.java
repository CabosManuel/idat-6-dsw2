package pe.idat.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.idat.model.Conyuge;
import pe.idat.repository.ConyugeRepository;

@Service
public class ConyugeServiceImpl implements ConyugeService{

	@Autowired
	private ConyugeRepository repository;
	
	@Override
	@Transactional
	public void insert(Conyuge conyuge) {
		repository.save(conyuge);
	}

	@Override
	@Transactional
	public void update(Conyuge conyuge) {
		repository.save(conyuge);
	}

	@Override
	@Transactional
	public void delete(Long dni) {
		repository.deleteById(dni);
	}

	@Override
	@Transactional(readOnly=true)
	public Conyuge findById(Long dni) {
		return repository.findById(dni).orElse(null);
	}

	@Override
	@Transactional(readOnly=true)
	public Collection<Conyuge> findAll() {
		return (Collection<Conyuge>)repository.findAll();
	}
	
}
