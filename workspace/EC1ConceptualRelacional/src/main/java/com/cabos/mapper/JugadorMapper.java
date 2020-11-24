package com.cabos.mapper;

public class JugadorMapper {
	private String nombreUsuario;
	private Integer nJuegos;
	private Integer horasJugadas;
	
	public JugadorMapper() {
	}
	
	public JugadorMapper(String nombreUsuario, Integer nJuegos, Integer horasJugadas) {
		super();
		this.nombreUsuario = nombreUsuario;
		this.nJuegos = nJuegos;
		this.horasJugadas = horasJugadas;
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
