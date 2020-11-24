package com.cabos.mapper;

public class VideojuegosMapper {
	private String nombre;
	private String precio;
	private String genero;
	
	public VideojuegosMapper() {
	}
	
	public VideojuegosMapper(String nombre, String precio, String genero) {
		super();
		this.nombre = nombre;
		this.precio = precio;
		this.genero = genero;
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
