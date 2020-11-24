package com.cabos.model;

public class JugadorVideojuego {
	private Jugador jugador;
	private Videojuego videojuego;
	
	public JugadorVideojuego() {
	}

	public JugadorVideojuego(Jugador jugador, Videojuego videojuego) {
		super();
		this.jugador = jugador;
		this.videojuego = videojuego;
	}

	public Jugador getJugador() {
		return jugador;
	}

	public void setJugador(Jugador jugador) {
		this.jugador = jugador;
	}

	public Videojuego getVideojuego() {
		return videojuego;
	}

	public void setVideojuego(Videojuego videojuego) {
		this.videojuego = videojuego;
	}
	
	
}
