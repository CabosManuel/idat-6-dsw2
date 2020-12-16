package pe.company.service;

import java.util.Collection;

import pe.company.model.Producto;

public interface ProductoService 
{
	public abstract void insert(Producto producto);
	public abstract void update(Producto producto);
	public abstract void delete(Integer id_producto);
	public abstract Producto findById(Integer id_producto);
	public abstract Collection<Producto> findAll();
}
