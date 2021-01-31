package com.cabos.model;

public class Dlc {

	private Integer idDlc;
	private String titulo;
	private Double precio;
	private String tipo;
	private String contenido;
	private String videojuego;

	public Dlc() {
	}

	public Dlc(Integer idDlc, String titulo, Double precio, String tipo, String contenido, String videojuego) {
		this.idDlc = idDlc;
		this.titulo = titulo;
		this.precio = precio;
		this.tipo = tipo;
		this.contenido = contenido;
		this.videojuego = videojuego;
	}

	public Integer getIdDlc() {
		return idDlc;
	}

	public void setIdDlc(Integer idDlc) {
		this.idDlc = idDlc;
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

	public String getVideojuego() {
		return videojuego;
	}

	public void setVideojuego(String videojuego) {
		this.videojuego = videojuego;
	}

}
