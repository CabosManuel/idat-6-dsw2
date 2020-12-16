package com.cabos.mapper;

import java.util.Collection;

import com.cabos.model.Videojuego;

public class JugadorMapper {
	private Integer id;
	private String nombreUsuario;
	private Integer nJuegos;
	private Integer horasJugadas;
	private Collection<VideojuegoMapper> videojuegos;
	
	public JugadorMapper() {
	}
	
	public JugadorMapper(Integer id, String nombreUsuario, Integer nJuegos, Integer horasJugadas) {
		this.id = id;
		this.nombreUsuario = nombreUsuario;
		this.nJuegos = nJuegos;
		this.horasJugadas = horasJugadas;
	}
	
	public JugadorMapper(Integer id, String nombreUsuario, Integer nJuegos, Integer horasJugadas, Collection<VideojuegoMapper> videojuegos) {
		this.id = id;
		this.nombreUsuario = nombreUsuario;
		this.nJuegos = nJuegos;
		this.horasJugadas = horasJugadas;
		this.videojuegos = videojuegos;
	}
	
	public Collection<VideojuegoMapper> getVideojuegos() {
		return videojuegos;
	}

	public void setVideojuegos(Collection<VideojuegoMapper> videojuegos) {
		this.videojuegos = videojuegos;
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
