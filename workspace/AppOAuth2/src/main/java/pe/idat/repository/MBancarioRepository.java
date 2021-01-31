package pe.idat.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import pe.idat.model.MBancario;

public interface MBancarioRepository extends CrudRepository<MBancario,Integer>
{
	@Query(value="select * from mbancarios where user_id=?1",nativeQuery=true)
	public abstract Collection<MBancario> findAll(Integer userId);
}
