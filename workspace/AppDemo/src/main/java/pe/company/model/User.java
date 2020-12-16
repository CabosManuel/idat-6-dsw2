package pe.company.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class User implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_user;
	
	@Column(unique = true,nullable = false)
	private String username;
	@Column(nullable = false)
	private String password;
	@Column
	private String nombre;
	@Column(unique = true,nullable = false)
	private String email;
	
	@ManyToMany
	@JoinTable(name="users_roles",
				joinColumns = @JoinColumn(name="id_user",nullable = false,
					foreignKey = @ForeignKey(foreignKeyDefinition = 
					"foreign key(id_user) references users(id_user)")),
				inverseJoinColumns=@JoinColumn(name="id_role",nullable = false,
					foreignKey = @ForeignKey(foreignKeyDefinition = 
					"foreign key(id_role) references roles(id_role)"))
			)
	private Set<Role> itemsRole=new HashSet<>();
	
	public User() {		
	}

	public User(Integer id_user, String username, String password, String nombre, String email) {
		this.id_user = id_user;
		this.username = username;
		this.password = password;
		this.nombre = nombre;
		this.email = email;
	}

	
	
	public Integer getId_user() {
		return id_user;
	}

	public void setId_user(Integer id_user) {
		this.id_user = id_user;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public Set<Role> getItemsRole() {
		return itemsRole;
	}

	public void setItemsRole(Set<Role> itemsRole) {
		this.itemsRole = itemsRole;
	}

	//para evitar duplicidad entre 2 o más atributos
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id_user == null) ? 0 : id_user.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (id_user == null) {
			if (other.id_user != null)
				return false;
		} else if (!id_user.equals(other.id_user))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
	
	
}
