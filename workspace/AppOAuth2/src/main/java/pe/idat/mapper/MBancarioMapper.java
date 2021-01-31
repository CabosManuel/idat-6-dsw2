package pe.idat.mapper;

import pe.idat.model.MBancario;

public class MBancarioMapper 
{
	private Double importe;
	private String detalle;
	private String nombre;
	
	public MBancarioMapper() {		
	}
	
	public MBancarioMapper(MBancario mbancario) {
		this(mbancario.getImporte(),mbancario.getDetalle(),mbancario.getUser().getNombre());
	}

	public MBancarioMapper(Double importe, String detalle, String nombre) {
		this.importe = importe;
		this.detalle = detalle;
		this.nombre = nombre;
	}

	public Double getImporte() {
		return importe;
	}

	public void setImporte(Double importe) {
		this.importe = importe;
	}

	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
