package pe.company.model;

import java.io.Serializable;

public class Role implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3438623562511886315L;

	private Integer id_role;
	
	private String type;
	
	public Role() {		
	}

	public Role(Integer id_role, String type) {
		this.id_role = id_role;
		this.type = type;
	}

	public Integer getId_role() {
		return id_role;
	}

	public void setId_role(Integer id_role) {
		this.id_role = id_role;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
