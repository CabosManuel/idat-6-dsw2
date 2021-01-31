package com.cabos.mapper;

public class VideojuegoMapper {
	private Integer idVideojuego;
	private String nombre;
	private Double precio;
	private String genero;

	public VideojuegoMapper() {
	}

	public VideojuegoMapper(Integer idVideojuego, String nombre, Double precio, String genero) {
		this.idVideojuego = idVideojuego;
		this.nombre = nombre;
		this.precio = precio;
		this.genero = genero;
	}

	public Integer getIdVideojuego() {
		return idVideojuego;
	}

	public void setIdVideojuego(Integer idVideojuego) {
		this.idVideojuego = idVideojuego;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

}
