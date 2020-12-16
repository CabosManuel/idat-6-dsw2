package com.cabos.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="jugadores")
public class Jugador implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idJugador;
	
	@Column
	private String nombreUsuario;
	@Column
	private Integer nJuegos;
	@Column
	private Integer horasJugadas;
	
	@OneToOne(mappedBy = "jugador",
			cascade = CascadeType.REMOVE) // cascade, para eliminar junto con la otra tabla
	private InformacionPersonal idInfoPersonal;
	
	@ManyToMany(cascade = {
			CascadeType.PERSIST,
			CascadeType.MERGE
	})
	@JoinTable(name="jugadores_vieojuegos", // tabla intermedia
		// FK1
		joinColumns = @JoinColumn(
				name="id_jugador",
				nullable=false,
				foreignKey = @ForeignKey(
						foreignKeyDefinition =
							"foreign key(id_jugador) references jugadores(id_jugador)")), 
		// FK2
		inverseJoinColumns = @JoinColumn(
				name="id_videojuego",
				nullable=false,
				foreignKey = @ForeignKey(
						foreignKeyDefinition = 
							"foreign key(id_videojuego) references videojuegos(id_videojuego)")))
	private Set<Videojuego> listaVideojuegos = new HashSet<>();
		
	public Jugador() {
	}

	public Jugador(Integer idJugador, String nombreUsuario, Integer nJuegos, Integer horasJugadas) {
		this.idJugador = idJugador;
		this.nombreUsuario = nombreUsuario;
		this.nJuegos = nJuegos;
		this.horasJugadas = horasJugadas;
	}
	
	public void addVideojuego(Videojuego videojuego) {
		listaVideojuegos.add(videojuego);
	}

	public Integer getIdJugador() {
		return idJugador;
	}

	public void setIdJugador(Integer idJugador) {
		this.idJugador = idJugador;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public Integer getnJuegos() {
		return nJuegos;
	}

	public void setnJuegos(Integer nJuegos) {
		this.nJuegos = nJuegos;
	}

	public Integer getHorasJugadas() {
		return horasJugadas;
	}

	public void setHorasJugadas(Integer horasJugadas) {
		this.horasJugadas = horasJugadas;
	}

	public InformacionPersonal getIdInfoPersonal() {
		return idInfoPersonal;
	}

	public void setIdInfoPersonal(InformacionPersonal idInfoPersonal) {
		this.idInfoPersonal = idInfoPersonal;
	}

	public Set<Videojuego> getListaVideojuegos() {
		return listaVideojuegos;
	}

	public void setListaVideojuegos(Set<Videojuego> listaVideojuegos) {
		this.listaVideojuegos = listaVideojuegos;
	}
	
	
	
}
