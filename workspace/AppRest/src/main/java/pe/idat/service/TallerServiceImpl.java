package pe.idat.service;

import java.util.Collection;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.idat.model.Taller;
import pe.idat.repository.TallerRepository;

@Service
public class TallerServiceImpl implements TallerService{

	private TallerRepository repo;
	
	@Override
	@Transactional
	public void insert(Taller taller) {
		// TODO Auto-generated method stub
		repo.save(taller);
	}

	@Override
	@Transactional
	public void update(Taller taller) {
		// TODO Auto-generated method stub
		repo.save(taller);
	}

	@Override
	@Transactional
	public void delete(Integer idTaller) {
		// TODO Auto-generated method stub
		repo.deleteById(idTaller);
	}

	@Override
	@Transactional(readOnly=true)
	public Taller findById(Integer idTaller) {
		// TODO Auto-generated method stub
		return repo.findById(idTaller).orElse(null);
	}

	@Override
	@Transactional(readOnly=true)
	public Collection<Taller> findAll() {
		// TODO Auto-generated method stub
		return (Collection<Taller>)repo.findAll();
	}

}
