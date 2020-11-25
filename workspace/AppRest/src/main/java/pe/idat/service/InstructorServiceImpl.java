package pe.idat.service;

import java.util.Collection;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.idat.model.Instructor;
import pe.idat.repository.InstructorRepository;

@Service
public class InstructorServiceImpl implements InstructorService {

	@Autowired // inyección de dependencia
	private InstructorRepository repository;

	@Override
	@Transactional // agrega la conexión, rolback (transaccion fuerte)
	public void insert(Instructor instructor) {
		repository.save(instructor);
	}

	@Override
	@Transactional
	public void update(Instructor instructor) {
		repository.save(instructor);
	}

	@Override
	@Transactional
	public void delete(Integer instructorId) {
		repository.deleteById(instructorId);
	}

	@Override
	@Transactional(readOnly = true) // (transaccion debil)
	public Instructor findById(Integer instructorId) {
		return repository.findById(instructorId).orElse(null);
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<Instructor> findAll() {
		return (Collection<Instructor>) repository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Instructor findByPasswordAndEmail(Instructor instructor) {
		Instructor instructorDb = repository.findByPasswordAndEmail(instructor.getPassword(), instructor.getEmail());

		if (instructorDb != null)
			return instructorDb;

		return null;
	}

	@Override
	@Transactional(readOnly = true)
	public Instructor findByEmail(String email) {
		return repository.findByEmail(email);
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<Instructor> findAllByFcontrato(Date fcontrato) {
		return repository.findAllByFcontrato(fcontrato);
	}

}
