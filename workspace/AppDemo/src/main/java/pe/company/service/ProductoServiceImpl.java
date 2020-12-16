package pe.company.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.company.model.Producto;
import pe.company.repository.ProductoRepository;

@Service
public class ProductoServiceImpl implements ProductoService 
{
	@Autowired
	private ProductoRepository repository;

	@Override
	@Transactional
	public void insert(Producto producto) {
		repository.save(producto);		
	}

	@Override
	@Transactional
	public void update(Producto producto) {
		repository.save(producto);
	}

	@Override
	@Transactional
	public void delete(Integer id_producto) {
		repository.deleteById(id_producto);		
	}

	@Override
	@Transactional(readOnly=true)
	public Producto findById(Integer id_producto) {
		return repository.findById(id_producto).orElse(null);
	}

	@Override
	@Transactional(readOnly=true)
	public Collection<Producto> findAll() {
		return (Collection<Producto>)repository.findAll();
	}
}
