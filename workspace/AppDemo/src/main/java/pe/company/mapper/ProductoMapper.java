package pe.company.mapper;

import pe.company.model.Producto;

public class ProductoMapper {

	private Integer idProducto;
	private String nombre;
	private Double precio;
	private Integer stock;
	private Integer idCategoria;

	public ProductoMapper(Producto p) {
		this(p.getId_producto(), p.getNombre(), p.getPrecio(), p.getStock(), p.getCategoria().getId_categoria());
	}

	public ProductoMapper(Integer idProducto, String nombre, Double precio, Integer stock, Integer idCategoria) {
		this.idProducto = idProducto;
		this.nombre = nombre;
		this.precio = precio;
		this.stock = stock;
		this.idCategoria = idCategoria;
	}

	public Integer getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(Integer idProducto) {
		this.idProducto = idProducto;
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

	public Integer getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(Integer idCategoria) {
		this.idCategoria = idCategoria;
	}

}
