package pe.idat.model;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="talleres")
public class Taller implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private Integer idTaller;
	
	@Column
	private String nombre;
	@Column
	private Integer creditos;
	@Column
	private Double costo;
	
	
	@ManyToOne
	@JoinColumn(
			name="id_instructor",
			nullable=false,
			foreignKey = @ForeignKey(
					foreignKeyDefinition = 
					"foreign key talleres(id_instructor) references instructores(talleres)"
			)
	)
	private Instructor instructor;
	
	
	
	public Taller() {
	}

	public Taller(Integer idTaller, String nombre, Integer creditos, Double costo) {
		super();
		this.idTaller = idTaller;
		this.nombre = nombre;
		this.creditos = creditos;
		this.costo = costo;
	}

	public Integer getIdTaller() {
		return idTaller;
	}

	public void setIdTaller(Integer idTaller) {
		this.idTaller = idTaller;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getCreditos() {
		return creditos;
	}

	public void setCreditos(Integer creditos) {
		this.creditos = creditos;
	}

	public Double getCosto() {
		return costo;
	}

	public void setCosto(Double costo) {
		this.costo = costo;
	}

	public Instructor getInstructor() {
		return instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}
	
	
	
	
}
