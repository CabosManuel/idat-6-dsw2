package pe.idat.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="users")
public class User implements Serializable
{
	private static final long serialVersionUID=1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer userId;
	
	@Column(unique=true,nullable=false)
	private String username;
	
	@Column(nullable=false)
	private String password;
	
	@Column
	private String nombre;
	
	@Temporal(TemporalType.DATE)
	private Date dateCreated;
	
	@OneToMany(mappedBy="user")
	private Collection<MBancario> itemsMBancario=new ArrayList<>();
	
	public User() {		
	}

	public User(Integer userId, String username, String password, String nombre, Date dateCreated) {
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.nombre = nombre;
		this.dateCreated = dateCreated;
	}
	
	@PrePersist
	public void prePersist() {
		dateCreated=new Date();
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Collection<MBancario> getItemsMBancario() {
		return itemsMBancario;
	}

	public void setItemsMBancario(Collection<MBancario> itemsMBancario) {
		this.itemsMBancario = itemsMBancario;
	}
}
