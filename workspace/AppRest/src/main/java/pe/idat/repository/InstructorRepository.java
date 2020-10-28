package pe.idat.repository;

import org.springframework.data.repository.CrudRepository;

import pe.idat.model.Instructor;

public interface InstructorRepository extends CrudRepository<Instructor,Integer>{
	
}
