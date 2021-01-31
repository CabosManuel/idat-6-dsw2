package com.cabos.mapper;

public class DlcMapper {
	private Integer idDlc;
	private String titulo;
	private Double precio;
	private String tipo;
	private String contenido;

	public DlcMapper() {
	}

	public DlcMapper(Integer idDlc, String titulo, Double precio, String tipo, String contenido) {
		this.idDlc = idDlc;
		this.titulo = titulo;
		this.precio = precio;
		this.tipo = tipo;
		this.contenido = contenido;
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

}
