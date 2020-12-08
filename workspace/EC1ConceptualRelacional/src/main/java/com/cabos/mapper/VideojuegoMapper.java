package com.cabos.mapper;

public class VideojuegoMapper {
	private Integer id;
	private String nombre;
	private String precio;
	private String genero;

	public VideojuegoMapper() {
	}

	public VideojuegoMapper(Integer id, String nombre, String precio, String genero) {
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
		this.genero = genero;
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

	public String getPrecio() {
		return precio;
	}

	public void setPrecio(String precio) {
		this.precio = precio;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

}
