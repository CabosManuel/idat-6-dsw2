package pe.idat.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="instructores")
public class Instructor implements Serializable{ //Serializable para mayor "seguridad"
   	
	private static final long serialVersionUID = 1L;
	
	@Id
    // Empieza en 101 e incrementa en 5
    // @TableGenerator(name="newGenerater",initialValue=101,allocationSize=5)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer idInstructor;
   	
   	@Column
    private String nombre;
   	@Column
    private String apellido;
   	@Column
    private String password;
   	@Column(unique=true,nullable=false)
    private String email;
   	@Temporal(TemporalType.DATE) //foramato yyyy-mm-dd
    private Date fContrato;
   	
   	// 1,1
   	@OneToOne(mappedBy="instructor")
   	private Conyuge conyuge;
   	
   	// 1,N
   	@OneToMany(mappedBy="instructor")
   	private Collection<Taller> itemsTaller=new ArrayList<>();
    
   	// N,M
   	@ManyToMany(cascade = {
			CascadeType.PERSIST,
			CascadeType.MERGE
	})
	@JoinTable(name="instructor_tecnologia", // tabla intermedia
		// FK1
		joinColumns = @JoinColumn(
				name="id_instructor",
				nullable=false,
				foreignKey = @ForeignKey(
						foreignKeyDefinition =
							"foreign key(id_instructor) references instructores(id_instructor)")), 
		// FK2
		inverseJoinColumns = @JoinColumn(
				name="id_tecnologia",
				nullable=false,
				foreignKey = @ForeignKey(
						foreignKeyDefinition = 
							"foreign key(id_tecnologia) references tecnologias(id_tecnologia)")))
   	private Set<Tecnologia> itemsTecnologia = new HashSet<>();
   	
   	// metodo para agrega una tecnologia
   	public void addTecnologia(Tecnologia tecnologia) {
   		itemsTecnologia.add(tecnologia);
   	}
   	
    public Instructor(){
    }

	public Instructor(Integer idInstructor, String nombre, String apellido, String password, String email,
			Date fContrato) {
		super();
		this.idInstructor = idInstructor;
		this.nombre = nombre;
		this.apellido = apellido;
		this.password = password;
		this.email = email;
		this.fContrato = fContrato;
	}

	@PrePersist
	public void pre() {
		fContrato= new Date();
	}
	
	public Integer getIdInstructor() {
		return idInstructor;
	}

	public void setIdInstructor(Integer idInstructor) {
		this.idInstructor = idInstructor;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getfContrato() {
		return fContrato;
	}

	public void setfContrato(Date fContrato) {
		this.fContrato = fContrato;
	}

	public Conyuge getConyuge() {
		return conyuge;
	}

	public void setConyugue(Conyuge conyuge) {
		this.conyuge = conyuge;
	}

	public Collection<Taller> getItemsTaller() {
		return itemsTaller;
	}

	public void setItemsTaller(Collection<Taller> itemsTaller) {
		this.itemsTaller = itemsTaller;
	}

	public Set<Tecnologia> getItemsTecnologia() {
		return itemsTecnologia;
	}

	public void setItemsTecnologia(Set<Tecnologia> itemsTecnologia) {
		this.itemsTecnologia = itemsTecnologia;
	}
    
    
}