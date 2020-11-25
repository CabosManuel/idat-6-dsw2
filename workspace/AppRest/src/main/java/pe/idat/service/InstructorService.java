package pe.idat.service;

import java.util.Collection;
import java.util.Date;

import pe.idat.model.Instructor;

public interface InstructorService {
	public void insert(Instructor instructor);
	public void update(Instructor instructor);
	public void delete(Integer instructorId);
	public Instructor findById(Integer instructorId);
	public Collection<Instructor> findAll();
	
	public Instructor findByPasswordAndEmail(Instructor instructor);
	public Instructor findByEmail(String email);
	
	public Collection<Instructor> findAllByFcontrato(Date fcontrato);
}
