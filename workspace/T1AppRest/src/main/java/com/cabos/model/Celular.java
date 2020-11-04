package com.cabos.model;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "celulares")
public class Celular implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idCelular;
	
	@Column
	private String modelo;
	@Column
	private String marca;
	@Column
	private Double precio;
	@Column
	private Integer tamano;
	
	public Celular() {
	}

	public Celular(Integer idCelular, String modelo, String marca, Double precio, Integer tamano) {
		super();
		this.idCelular = idCelular;
		this.modelo = modelo;
		this.marca = marca;
		this.precio = precio;
		this.tamano = tamano;
	}

	public Integer getIdCelular() {
		return idCelular;
	}

	public void setIdCelular(Integer idCelular) {
		this.idCelular = idCelular;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public Integer getTamano() {
		return tamano;
	}

	public void setTamano(Integer tamano) {
		this.tamano = tamano;
	}
}
