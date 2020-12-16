package pe.company.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import pe.company.model.User;

public interface UserRepository extends CrudRepository<User, Integer>{
	
	@Query(value = "select * from users where username=?",nativeQuery = true)
	public User findByUsername(String username);
}
