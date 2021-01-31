package com.cabos.mapper;

public class VideojuegoReducidoMapper {
	private Integer id;
	private String nombre;

	public VideojuegoReducidoMapper() {
	}

	public VideojuegoReducidoMapper(Integer id, String nombre, Double precio, String genero) {
		this.id = id;
		this.nombre = nombre;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
