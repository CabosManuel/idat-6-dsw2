package pe.company.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="productos")
public class Producto implements Serializable
{
	private static final long serialVersionUID=1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id_producto;
	
	@Column
	private String nombre;
	
	@Column
	private Double precio;
	
	@Column
	private Integer stock;
	
	@ManyToOne
	@JoinColumn(name="id_categoria",nullable=false,
	            foreignKey=@ForeignKey(foreignKeyDefinition="foreign key(id_categoria) references categorias(id_categoria)"))
	private Categoria categoria;
	
	public Producto() {		
	}

	public Producto(Integer id_producto, String nombre, Double precio, Integer stock) {
		this.id_producto = id_producto;
		this.nombre = nombre;
		this.precio = precio;
		this.stock = stock;
	}

	public Integer getId_producto() {
		return id_producto;
	}

	public void setId_producto(Integer id_producto) {
		this.id_producto = id_producto;
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

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
}
