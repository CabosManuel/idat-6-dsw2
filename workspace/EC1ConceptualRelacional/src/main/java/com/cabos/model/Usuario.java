package com.cabos.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "usuario")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idUsuario;
	
	@Column(unique = true, nullable = false)
	private String nomUsuario;
	@Column(nullable = false)
	private String password;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "usuarios_roles",
			joinColumns = @JoinColumn(name = "id_usuario", nullable = false,
					foreignKey = @ForeignKey(foreignKeyDefinition = 
							"foreign key(id_usuario) references usuario(id_usuario)")),
			inverseJoinColumns = @JoinColumn(name = "id_rol", nullable = false,
					foreignKey = @ForeignKey(foreignKeyDefinition = 
							"foreign key(id_rol) references rol(id_rol)")))
	private Set<Rol> roles = new HashSet<>();

	public Usuario() {
	}

	public Usuario(Integer idUsuario, String nomUsuario, String password) {
		this.idUsuario = idUsuario;
		this.nomUsuario = nomUsuario;
		this.password = password;
	}

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNomUsuario() {
		return nomUsuario;
	}

	public void setNomUsuario(String nomUsuario) {
		this.nomUsuario = nomUsuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public Set<Rol> getRoles() {
		return roles;
	}

	public void setRoles(Set<Rol> roles) {
		this.roles = roles;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idUsuario == null) ? 0 : idUsuario.hashCode());
		result = prime * result + ((nomUsuario == null) ? 0 : nomUsuario.hashCode());
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
		Usuario other = (Usuario) obj;
		if (idUsuario == null) {
			if (other.idUsuario != null)
				return false;
		} else if (!idUsuario.equals(other.idUsuario))
			return false;
		if (nomUsuario == null) {
			if (other.nomUsuario != null)
				return false;
		} else if (!nomUsuario.equals(other.nomUsuario))
			return false;
		return true;
	}
	
}
