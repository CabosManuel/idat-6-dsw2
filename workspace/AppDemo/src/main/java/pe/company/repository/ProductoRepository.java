package pe.company.repository;

import org.springframework.data.repository.CrudRepository;

import pe.company.model.Producto;

public interface ProductoRepository extends CrudRepository<Producto, Integer> {

}
