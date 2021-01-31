package com.cabos.mapper;

public class DlcVideojuegoMapper extends DlcMapper{

	private String videojuego;

	public DlcVideojuegoMapper() {
	}

	public DlcVideojuegoMapper(Integer idDlc, String titulo, Double precio, String tipo, String contenido, String videojuego) {
		super(idDlc, titulo, precio, tipo, contenido);
		this.videojuego = videojuego;
	}
	
	public String getVideojuego() {
		return videojuego;
	}

	public void setVideojuego(String videojuego) {
		this.videojuego = videojuego;
	}

}
