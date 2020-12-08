package com.cabos.mapper;

import java.time.LocalDate;
import java.util.Date;

public class InfoPersonalMapper {
	private Integer id;
	private String nombresApellidos;
	private String usaurio;
	private String correo;
	private LocalDate fNacimiento;
	//private Integer edad;

	public InfoPersonalMapper() {
	}

	public InfoPersonalMapper(Integer id, String nombresApellidos, String usaurio, String correo, LocalDate fNacimiento/*,
			Integer edad*/) {
		this.id = id;
		this.nombresApellidos = nombresApellidos;
		this.usaurio = usaurio;
		this.correo = correo;
		this.fNacimiento = fNacimiento;
		//this.edad = edad;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombresApellidos() {
		return nombresApellidos;
	}

	public void setNombresApellidos(String nombresApellidos) {
		this.nombresApellidos = nombresApellidos;
	}

	public String getUsaurio() {
		return usaurio;
	}

	public void setUsaurio(String usaurio) {
		this.usaurio = usaurio;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public LocalDate getfNacimiento() {
		return fNacimiento;
	}

	public void setfNacimiento(LocalDate fNacimiento) {
		this.fNacimiento = fNacimiento;
	}

	/*
	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}*/
}
