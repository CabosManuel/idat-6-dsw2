package pe.idat.model;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="conyuges")
public class Conyuge implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	private Long dni;
	
	@Column
	private String nombre;
	
	@OneToOne
	@JoinColumn(
			name="id_instructor",
			nullable=false,
			unique=true,
			foreignKey=@ForeignKey(
					foreignKeyDefinition =
					"foreign key(id_instructor) references instructores(id_instructor)"))
					// foreign key(name) 
	private Instructor instructor;
	
	public Conyuge() {
	}

	public Conyuge(Long dni, String nombre) {
		super();
		this.dni = dni;
		this.nombre = nombre;
	}

	public Long getDni() {
		return dni;
	}

	public void setDni(Long dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Instructor getInstructor() {
		return instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}
	
	
}
