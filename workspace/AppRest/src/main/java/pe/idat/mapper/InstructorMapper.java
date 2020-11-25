package pe.idat.mapper;

import java.util.Date;

public class InstructorMapper {
	private Integer idInstructor;
	private String nombres;
	private String apellidos;
	private String email;
	private String password;
	private Date fContrato;

	public InstructorMapper() {

	}

	public InstructorMapper(Integer idInstructor, String nombres, String apellidos, String email, String password,
			Date fContrato) {
		this.idInstructor = idInstructor;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.email = email;
		this.password = password;
		this.fContrato = fContrato;
	}

	public Integer getIdInstructor() {
		return idInstructor;
	}

	public void setIdInstructor(Integer idInstructor) {
		this.idInstructor = idInstructor;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getfContrato() {
		return fContrato;
	}

	public void setfContrato(Date fContrato) {
		this.fContrato = fContrato;
	}

}
