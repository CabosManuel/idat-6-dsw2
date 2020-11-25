package pe.idat.mapper;

import java.util.ArrayList;
import java.util.Collection;

import pe.idat.model.Instructor;

public class MapperUtil {
	public static Collection<InstructorMapper> convert(Collection<Instructor> itemsInstructor) {
		Collection<InstructorMapper> collection = new ArrayList<>();

		for (Instructor instructor : itemsInstructor) {
			InstructorMapper mapper = new InstructorMapper();

			mapper.setIdInstructor(instructor.getIdInstructor());
			mapper.setNombres(instructor.getNombre());
			mapper.setApellidos(instructor.getApellido());
			mapper.setPassword(instructor.getPassword());
			mapper.setEmail(instructor.getEmail());
			mapper.setfContrato(instructor.getfContrato());

			collection.add(mapper);
		}

		return collection;
	}

	public static InstructorMapper2 convertToMapper2(Instructor instrcutor) {
		InstructorMapper2 mapper = new InstructorMapper2();

		mapper.setApellidos(instrcutor.getApellido());
		mapper.setEmail(instrcutor.getEmail());
		mapper.setFcontrato(instrcutor.getfContrato());
		mapper.setNombres(instrcutor.getNombre());

		return mapper;
	}
}
