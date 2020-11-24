package com.cabos.mapper;

import java.util.ArrayList;
import java.util.Collection;

import com.cabos.model.Jugador;
import com.cabos.model.Videojuego;

public class MapperUtil {
	public static Collection<JugadorMapper> convertJugador(Collection<Jugador> jugadores){
		Collection<JugadorMapper> jugadoresMapper = new ArrayList<>();
		
		for(Jugador jugador:jugadores) {
			JugadorMapper mapper = new JugadorMapper();
			
			mapper.setNombreUsuario(jugador.getNombreUsuario());
			mapper.setnJuegos(jugador.getnJuegos());
			mapper.setHorasJugadas(jugador.getHorasJugadas());
			
			jugadoresMapper.add(mapper);
		}
		
		return jugadoresMapper;
	}
	
	public static Collection<VideojuegosMapper> convertVideojuego(Collection<Videojuego> videojuegos){
		Collection<VideojuegosMapper> videojuegosMapper = new ArrayList<>();
		
		for(Videojuego videojuego:videojuegos) {
			VideojuegosMapper mapper = new VideojuegosMapper();
			
			mapper.setGenero(videojuego.getGenero());
			mapper.setNombre(videojuego.getNombre());
			mapper.setPrecio("S/."+videojuego.getPrecio());
			
			videojuegosMapper.add(mapper);
		}
		
		return videojuegosMapper;
	}
}
