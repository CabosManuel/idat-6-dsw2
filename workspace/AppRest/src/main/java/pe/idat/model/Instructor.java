package pe.idat.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name="instructores")
public class Instructor implements Serializable{ //Serializable para mayor "seguridad"
   	
	private static final long serialVersionUID = 1L;
	
	@Id
    //Empieza en 101 e incrementa en 5
    //@TableGenerator(name="newGenerater",initialValue=101,allocationSize=5)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer instructorId;
   	
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
    
    public Instructor(){
    }

	public Instructor(Integer instructorId, String nombre, String apellido, String password, String email,
			Date fContrato) {
		super();
		this.instructorId = instructorId;
		this.nombre = nombre;
		this.apellido = apellido;
		this.password = password;
		this.email = email;
		this.fContrato = fContrato;
	}

	@PrePersist
	public void pre() {
		//fContrato
	}
	
	public Integer getInstructorId() {
		return instructorId;
	}

	public void setInstructorId(Integer instructorId) {
		this.instructorId = instructorId;
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
    
    
}