package com.cabos.model;

public class Celular {
	private Integer idCelular;
	private String modelo;
	private String marca;
	private Double precio;
	private Integer tamaño;
	
	public Celular() {
	}

	public Celular(Integer idCelular, String modelo, String marca, Double precio, Integer tamaño) {
		super();
		this.idCelular = idCelular;
		this.modelo = modelo;
		this.marca = marca;
		this.precio = precio;
		this.tamaño = tamaño;
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

	public Integer getTamaño() {
		return tamaño;
	}

	public void setTamaño(Integer tamaño) {
		this.tamaño = tamaño;
	}
}
