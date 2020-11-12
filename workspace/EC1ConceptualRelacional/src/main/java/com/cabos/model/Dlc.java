package com.cabos.model;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="dlc")
public class Dlc implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idDlc;
	
	@Column
	private String titulo;
	
	@Column
	private Double precio;
	
	@Column
	private String tipo;
	
	@Column
	private String contenido;
	
	@ManyToOne
	@JoinColumn(
			name="id_videojuego",
			nullable=false,
			foreignKey = @ForeignKey(
					foreignKeyDefinition =
						"foreign key(id_videojuego) references videojuegos(id_videojuego)"))
	private Videojuego videojuego;
	
	public Dlc() {
	}
	public Dlc(Integer idDlc, String titulo, Double precio, String tipo, String contenido) {
		super();
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
	public Videojuego getVideojuego() {
		return videojuego;
	}
	public void setVideojuego(Videojuego videojuego) {
		this.videojuego = videojuego;
	}
	
	
}
