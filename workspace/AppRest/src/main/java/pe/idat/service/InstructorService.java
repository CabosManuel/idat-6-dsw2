package pe.idat.service;

import java.util.Collection;

import pe.idat.model.Instructor;

public interface InstructorService {
	public void insert(Instructor instructor);
	public void update(Instructor instructor);
	public void delete(Integer instructorId);
	public Instructor findById(Integer instructorId);
	public Collection<Instructor> findAll();
}
