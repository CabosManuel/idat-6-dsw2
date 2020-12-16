package pe.company.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name="roles")
public class Role implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_role;
	
	@Column(unique = true,nullable = false)
	private String type;
	
	@ManyToMany(mappedBy="itemsRole")
	private Set<User> itemsUser = new HashSet<>();
	
	public Role() {		
	}

	public Role(Integer id_role, String type) {
		this.id_role = id_role;
		this.type = type;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id_role == null) ? 0 : id_role.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		Role other = (Role) obj;
		if (id_role == null) {
			if (other.id_role != null)
				return false;
		} else if (!id_role.equals(other.id_role))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

	public Integer getId_role() {
		return id_role;
	}

	public void setId_role(Integer id_role) {
		this.id_role = id_role;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Set<User> getItemsUser() {
		return itemsUser;
	}

	public void setItemsUser(Set<User> itemsUser) {
		this.itemsUser = itemsUser;
	}
	
	
}
