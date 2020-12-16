package pe.company.model;

import java.io.Serializable;

public class User implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private Integer id_user;
	private String username;
	private String password;
	private String nombre;
	private String email;
	
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
}
