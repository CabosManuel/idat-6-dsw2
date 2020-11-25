package pe.idat.repository;

import java.util.Collection;
import java.util.Date;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import pe.idat.model.Instructor;

public interface InstructorRepository extends CrudRepository<Instructor,Integer>{
	public abstract Instructor findByEmail(String email);
	public abstract Instructor findByPasswordAndEmail(String password,String email);
	
	@Query(value="select * from instructores where fcontrato=?",nativeQuery=true)
	public abstract Collection<Instructor> findAllByFcontrato(Date fcontrato);
}
