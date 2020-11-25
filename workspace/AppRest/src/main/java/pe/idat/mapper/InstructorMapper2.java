package pe.idat.mapper;

import java.util.Date;

public class InstructorMapper2 {

	private String nombres;
	private String apellidos;
	private String email;
	private Date fcontrato;

	public InstructorMapper2() {
	}

	public InstructorMapper2(String nombres, String apellidos, String email, Date fcontrato) {
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.email = email;
		this.fcontrato = fcontrato;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getFcontrato() {
		return fcontrato;
	}

	public void setFcontrato(Date fcontrato) {
		this.fcontrato = fcontrato;
	}

}
