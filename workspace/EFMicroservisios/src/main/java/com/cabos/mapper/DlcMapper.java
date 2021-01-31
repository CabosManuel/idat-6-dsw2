package com.cabos.mapper;

import com.cabos.model.Videojuego;

public class DlcMapper {
	private String titulo;
	private Double precio;
	private String tipo;
	private String contenido;
	private Videojuego videojuego;

	public DlcMapper() {
	}

	public DlcMapper(String titulo, Double precio, String tipo, String contenido, Videojuego videojuego) {
		this.titulo = titulo;
		this.precio = precio;
		this.tipo = tipo;
		this.contenido = contenido;
		this.videojuego = videojuego;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getContenido() {
		return contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}

	public Videojuego getVideojuego() {
		return videojuego;
	}

	public void setVideojuego(Videojuego videojuego) {
		this.videojuego = videojuego;
	}
}
