package com.cabos.mapper;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

import com.cabos.model.Dlc;
import com.cabos.model.InformacionPersonal;
import com.cabos.model.Jugador;
import com.cabos.model.Videojuego;

public class MapperUtil {
	
	// JUGADOR
	public static JugadorMapper convertJugador(Jugador j) {
		return new JugadorMapper(
				j.getIdJugador(),
				j.getNombreUsuario(), 
				j.getnJuegos(),
				j.getHorasJugadas(),
				convertCollVideojuego(j.getListaVideojuegos()));
	}
	
	public static Collection<JugadorMapper> convertCollJugadores(Collection<Jugador> jugadores){
		Collection<JugadorMapper> jugadoresMapper = new ArrayList<>();
		
		for(Jugador jugador:jugadores) {			
			JugadorMapper mapper = convertJugador(jugador);			
			jugadoresMapper.add(mapper);
		}
		
		return jugadoresMapper;
	}
	
	// INFORMACIÓN PERSONAL
	public static InfoPersonalMapper convertInfoPersonal(InformacionPersonal ip) {
		
		LocalDate fN = LocalDate.parse(ip.getfNacimiento());
		
		return new InfoPersonalMapper(
				ip.getIdInfoPersonal(), 
				ip.getNombres()+" "+ip.getApellidos(), 
				ip.getJugador().getNombreUsuario(), 
				ip.getCorreo(), 
				fN,
				LocalDate.now().getYear() - fN.getYear());
	}
	
	public static Collection<InfoPersonalMapper> convertCollInfoP(Collection<InformacionPersonal> infosPersonales){
		Collection<InfoPersonalMapper> infosPersonalesMapper = new ArrayList<>();
		
		for(InformacionPersonal infoPersonal:infosPersonales) {
			InfoPersonalMapper mapper = convertInfoPersonal(infoPersonal);
			infosPersonalesMapper.add(mapper);
		}
		
		return infosPersonalesMapper;
	}
	
	// VIDEOJUEGOS 
	public static VideojuegoMapper convertVideojuego(Videojuego videojuego) {
		VideojuegoMapper mapper = new VideojuegoMapper();
		mapper.setIdVideojuego(videojuego.getIdVideojuego());
		mapper.setGenero(videojuego.getGenero());
		mapper.setNombre(videojuego.getNombre());
		mapper.setPrecio(videojuego.getPrecio());
		
		return mapper;
	}
	
	public static Collection<VideojuegoMapper> convertCollVideojuego(Collection<Videojuego> videojuegos){
		Collection<VideojuegoMapper> videojuegosMapper = new ArrayList<>();
		
		for(Videojuego videojuego:videojuegos) {
			videojuegosMapper.add(convertVideojuego(videojuego));
		}
		
		return videojuegosMapper;
	}
	
	public static VideojuegoMapper convertVideojuegoDlcs(Videojuego videojuego) {
		VideojuegoDlcMapper mapper = new VideojuegoDlcMapper();
		mapper.setIdVideojuego(videojuego.getIdVideojuego());
		mapper.setGenero(videojuego.getGenero());
		mapper.setNombre(videojuego.getNombre());
		mapper.setPrecio(videojuego.getPrecio());
		mapper.setDlcs(MapperUtil.convertCollDlc(videojuego.getListaDlc()));
		
		return mapper;
	}
	
	// DLC
	public static DlcMapper convertDlc(Dlc dlc) {
		return new DlcMapper(
				dlc.getIdDlc(),
				dlc.getTitulo(),
				dlc.getPrecio(),
				dlc.getTipo(),
				dlc.getContenido());
	}
	
	public static Collection<DlcMapper> convertCollDlc(Collection<Dlc> dlcs){
		Collection<DlcMapper> dlcsMapper = new ArrayList<>();
		
		for(Dlc dlc:dlcs) {
			dlcsMapper.add(convertDlc(dlc));
		}
		
		return dlcsMapper;
	}
	
	public static DlcVideojuegoMapper convertDlcVideojuego(Dlc dlc) {
		return new DlcVideojuegoMapper(
				dlc.getIdDlc(),
				dlc.getTitulo(),
				dlc.getPrecio(),
				dlc.getTipo(),
				dlc.getContenido(),
				dlc.getVideojuego().getNombre());
	}
	
	public static Collection<DlcVideojuegoMapper> convertCollDlcVidejuego(Collection<Dlc> dlcs){
		Collection<DlcVideojuegoMapper> dlcsMapper = new ArrayList<>();
		
		for(Dlc dlc:dlcs) {
			dlcsMapper.add(convertDlcVideojuego(dlc));
		}
		
		return dlcsMapper;
	}
}
