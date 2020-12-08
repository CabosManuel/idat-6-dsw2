package com.cabos.mapper;

import java.util.ArrayList;
import java.util.Collection;

import com.cabos.model.Jugador;
import com.cabos.model.Videojuego;

public class MapperUtil {
	
	// JUGADOR
	public static JugadorMapper convertJugador(Jugador j) {
		return new JugadorMapper(j.getIdJugador(),j.getNombreUsuario(), 
				j.getnJuegos(),j.getHorasJugadas());
	}
	
	public static Collection<JugadorMapper> convertCollJugadores(Collection<Jugador> jugadores){
		Collection<JugadorMapper> jugadoresMapper = new ArrayList<>();
		
		for(Jugador jugador:jugadores) {			
			JugadorMapper mapper = convertJugador(jugador);			
			jugadoresMapper.add(mapper);
		}
		
		return jugadoresMapper;
	}
	
	// VIDEOJUEGOS 
	public static VideojuegoMapper convertVideojuego(Videojuego videojuego) {
		VideojuegoMapper mapper = new VideojuegoMapper();
		mapper.setId(videojuego.getIdVideojuego());
		mapper.setGenero(videojuego.getGenero());
		mapper.setNombre(videojuego.getNombre());
		mapper.setPrecio("S/."+videojuego.getPrecio());
		
		return mapper;
	}
	
	public static Collection<VideojuegoMapper> convertCollVideojuego(Collection<Videojuego> videojuegos){
		Collection<VideojuegoMapper> videojuegosMapper = new ArrayList<>();
		
		for(Videojuego videojuego:videojuegos) {
			videojuegosMapper.add(convertVideojuego(videojuego));
		}
		
		return videojuegosMapper;
	}
	
}
