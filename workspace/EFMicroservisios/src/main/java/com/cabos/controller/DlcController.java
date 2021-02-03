package com.cabos.controller;

import java.util.Arrays;
import java.util.Base64;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.support.BasicAuthenticationInterceptor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.cabos.mapper.DlcMapper;
import com.cabos.model.Dlc;
import com.cabos.util.BAInterceptor;
import com.cabos.util.Url;

@RestController
@RequestMapping(Url.DLC)
public class DlcController {

	@Autowired
	private RestTemplate rt;
	
	@GetMapping(value = Url.LISTAR, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> listar() {
		BAInterceptor.agregar(rt);
		Dlc[] dlcs = rt.getForObject(Url.URL_DLC + Url.LISTAR, Dlc[].class);
		Collection<Dlc> nuevosDlcs = Arrays.asList(dlcs);

		return new ResponseEntity<>(nuevosDlcs, HttpStatus.OK);
	}

	@PostMapping(value = Url.AGREGAR, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> registrar(@RequestBody DlcMapper dlc) {
		BAInterceptor.agregar(rt);
		rt.postForLocation(Url.URL_DLC + Url.AGREGAR, dlc);
		return new ResponseEntity<>("¡Creado!", HttpStatus.CREATED);
	}

	@PutMapping(value = Url.EDITAR + "/{idDlc}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> editar(@PathVariable Integer idDlc, @RequestBody DlcMapper dlc) {
		BAInterceptor.agregar(rt);
		rt.put(Url.URL_DLC + Url.EDITAR + "/" + idDlc, dlc);
		return new ResponseEntity<>("¡Editado!", HttpStatus.OK);
	}

	@DeleteMapping(value = Url.ELIMINAR + "/{idDlc}")
	public ResponseEntity<?> eliminar(@PathVariable Integer idDlc) {
		BAInterceptor.agregar(rt);
		rt.delete(Url.URL_DLC + Url.ELIMINAR + "/" + idDlc);
		return new ResponseEntity<>("!Eliminado!", HttpStatus.OK);
	}
}
