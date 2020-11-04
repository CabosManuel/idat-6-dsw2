package pe.idat.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="tecnologias")
public class Tecnologia implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idTecnologia;
	
	@Column
	private String nombre;
	
	@ManyToMany(cascade = {
			CascadeType.PERSIST,
			CascadeType.REFRESH
	})
	@JoinTable(name="instructores_tecnologias",
		joinColumns = @JoinColumn(
				name="id_instructor",
				nullable=false,
				
				// tabla intermedia
				// FK1
				foreignKey = @ForeignKey(
						foreignKeyDefinition = 
							"foreign key(id_instructor) references instructores(instructor_id)")),
				// FK2
				inverseForeignKey = @ForeignKey(
						foreignKeyDefinition = 
							"foreign key(id_tecnologia) references tecnologias(id_tegnologia)"
				)
	)
	private Set<Instructor> itemsInstructors = new HashSet<>();

	
	public Tecnologia(Integer idTecnologia, String nombre) {
		super();
		this.idTecnologia = idTecnologia;
		this.nombre = nombre;
	}
	public Integer getIdTecnologia() {
		return idTecnologia;
	}
	public void setIdTecnologia(Integer idTecnologia) {
		this.idTecnologia = idTecnologia;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Set<Instructor> getItemsInstructors() {
		return itemsInstructors;
	}
	public void setItemsInstructors(Set<Instructor> itemsInstructors) {
		this.itemsInstructors = itemsInstructors;
	}
	
	
}
