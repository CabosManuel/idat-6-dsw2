package com.cabos.mapper;

public class JugadorMapper {
	private Integer id;
	private String nombreUsuario;
	private Integer nJuegos;
	private Integer horasJugadas;
	
	public JugadorMapper() {
	}
	
	public JugadorMapper(Integer id, String nombreUsuario, Integer nJuegos, Integer horasJugadas) {
		this.id = id;
		this.nombreUsuario = nombreUsuario;
		this.nJuegos = nJuegos;
		this.horasJugadas = horasJugadas;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public Integer getnJuegos() {
		return nJuegos;
	}

	public void setnJuegos(Integer nJuegos) {
		this.nJuegos = nJuegos;
	}

	public Integer getHorasJugadas() {
		return horasJugadas;
	}

	public void setHorasJugadas(Integer horasJugadas) {
		this.horasJugadas = horasJugadas;
	}
	
	
}
