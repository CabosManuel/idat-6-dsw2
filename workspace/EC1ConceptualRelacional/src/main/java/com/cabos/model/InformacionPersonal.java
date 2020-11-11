package com.cabos.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="informacion_personal")
public class InformacionPersonal implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idInfoPersonal;
	
	@Column
	private String apellidos;
	
	@Column
	private String nombres;
	
	@Temporal(TemporalType.DATE)
	private Date fNacimiento;
	
	@Column
	private String correo;
	
	@Column
	private String contrasena;
	
	@OneToOne
	@JoinColumn(
			name="id_jugador",
			nullable=false,
			unique=true,
			foreignKey=@ForeignKey(
					foreignKeyDefinition = 
					"foreign key(id_jugador) references jugadores(id_jugador)"))
	private Jugador jugador;
	
	public InformacionPersonal() {
	
	}

	public InformacionPersonal(Integer idInfoPersonal, String apellidos, String nombres, Date fNacimiento,
			String correo, String contrasena) {
		super();
		this.idInfoPersonal = idInfoPersonal;
		this.apellidos = apellidos;
		this.nombres = nombres;
		this.fNacimiento = fNacimiento;
		this.correo = correo;
		this.contrasena = contrasena;
	}

	public Integer getIdInfoPersonal() {
		return idInfoPersonal;
	}

	public void setIdInfoPersonal(Integer idInfoPersonal) {
		this.idInfoPersonal = idInfoPersonal;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public Date getfNacimiento() {
		return fNacimiento;
	}

	public void setfNacimiento(Date fNacimiento) {
		this.fNacimiento = fNacimiento;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public Jugador getJugador() {
		return jugador;
	}

	public void setJugador(Jugador jugador) {
		this.jugador = jugador;
	}
	
}
