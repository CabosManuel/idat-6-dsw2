package pe.idat.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import pe.idat.model.User;

public interface UserRepository extends CrudRepository<User,Integer> 
{
	@Query(value="select * from users where username=?1",nativeQuery=true)
	public abstract User findByUsername(String username);
}
