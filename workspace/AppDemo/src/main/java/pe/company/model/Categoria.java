package pe.company.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="categorias")
public class Categoria implements Serializable
{
	private static final long serialVersionUID=1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id_categoria;
	
	@Column
	private String descripcion;
	
	@OneToMany(mappedBy="categoria")
	private Collection<Producto> itemsProducto=new ArrayList<>();
	
	public Categoria() {		
	}

	public Categoria(Integer id_categoria, String descripcion) {
		this.id_categoria = id_categoria;
		this.descripcion = descripcion;
	}

	public Integer getId_categoria() {
		return id_categoria;
	}

	public void setId_categoria(Integer id_categoria) {
		this.id_categoria = id_categoria;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Collection<Producto> getItemsProducto() {
		return itemsProducto;
	}

	public void setItemsProducto(Collection<Producto> itemsProducto) {
		this.itemsProducto = itemsProducto;
	}
}
