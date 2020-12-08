package com.cabos.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="videojuegos")
public class Videojuego implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idVideojuego;
	
	@Column
	private String nombre;
	
	@Column
	private Double precio;
	
	@Column
	private String genero;
	
	@OneToMany(mappedBy = "videojuego", cascade = CascadeType.REMOVE)
	private Collection<Dlc> listaDlc=new ArrayList<>(); 
	
	@ManyToMany(
			mappedBy="listaVideojuegos",
			cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private Set<Jugador> listaJugadores = new HashSet<>(); // HashSet, elementos no repeditos en la lista
	
	public Videojuego() {
	}

	public Videojuego(Integer idVideojuego, String nombre, Double precio, String genero) {
		super();
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

	public Collection<Dlc> getListaDlc() {
		return listaDlc;
	}

	public void setListaDlc(Collection<Dlc> listaDlc) {
		this.listaDlc = listaDlc;
	}

	public Set<Jugador> getListaJugadores() {
		return listaJugadores;
	}

	public void setListaJugadores(Set<Jugador> listaJugadores) {
		this.listaJugadores = listaJugadores;
	}
	
	
}
