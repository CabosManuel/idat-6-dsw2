package pe.idat.mapper;

import java.util.Date;

import pe.idat.model.User;

public class UserMapper 
{
	private String username;
	private String nombre;
	private Date dateCreated;
	
	public UserMapper() {		
	}
	
	public UserMapper(User user) {
		this(user.getUsername(),user.getNombre(),user.getDateCreated());
	}

	public UserMapper(String username, String nombre, Date dateCreated) {
		this.username = username;
		this.nombre = nombre;
		this.dateCreated = dateCreated;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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
}
