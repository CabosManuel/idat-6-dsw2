package pe.idat.model;

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
@Table(name="mbancarios")
public class MBancario implements Serializable
{
	private static final long serialVersionUID=1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer mbancarioId;
	
	@Column
	private Double importe;
	
	@Column
	private String detalle;
	
	@ManyToOne
	@JoinColumn(name="user_id",nullable=false,
			foreignKey=@ForeignKey(foreignKeyDefinition="foreign key(user_id) references users(user_id)"))
	private User user;
	
	public MBancario() {		
	}

	public MBancario(Integer mbancarioId, Double importe, String detalle) {
		this.mbancarioId = mbancarioId;
		this.importe = importe;
		this.detalle = detalle;
	}

	public Integer getMbancarioId() {
		return mbancarioId;
	}

	public void setMbancarioId(Integer mbancarioId) {
		this.mbancarioId = mbancarioId;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
