package com.cabos.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cabos.mapper.MapperUtil;
import com.cabos.model.Dlc;
import com.cabos.services.DlcService;

@RestController
@RequestMapping("/rest/dlc")
public class DlcRestController {

	@Autowired
	private DlcService service;

	@GetMapping("/listar")
	public ResponseEntity<?> listar() {
		Collection<Dlc> dlcs = service.findAll();

		if (dlcs.isEmpty())
			return new ResponseEntity<>("No existen Dlcs", HttpStatus.NO_CONTENT);

		return new ResponseEntity<>(MapperUtil.convertCollDlcVidejuego(dlcs), HttpStatus.OK);
	}

	@GetMapping("/buscar/{idDlc}")
	public ResponseEntity<?> buscar(@PathVariable Integer idDlc) {
		Dlc DlcDb = service.findById(idDlc);

		if (DlcDb != null)
			return new ResponseEntity<>(MapperUtil.convertDlcVideojuego(DlcDb), HttpStatus.OK);

		return new ResponseEntity<>("¡No existe un DLC con ID: " + idDlc + "!", HttpStatus.NOT_FOUND);
	}

	@PostMapping("/agregar")
	public ResponseEntity<?> agregar(@RequestBody Dlc dlc) {
		service.insert(dlc);
		return new ResponseEntity<>(
				"¡DLC \"" + dlc.getTitulo() + "\" con ID: " + dlc.getIdDlc() + ", agregado correctamente!",
				HttpStatus.CREATED);
	}

	@PutMapping("/editar/{idDlc}")
	public ResponseEntity<?> editar(@PathVariable Integer idDlc, @RequestBody Dlc newDlc) {
		Dlc oldDlc = service.findById(idDlc);

		if (oldDlc != null) {
			oldDlc.setTitulo(newDlc.getTitulo());
			oldDlc.setPrecio(newDlc.getPrecio());
			oldDlc.setTipo(newDlc.getTipo());
			oldDlc.setContenido(newDlc.getContenido());

			service.update(oldDlc);
			return new ResponseEntity<>(MapperUtil.convertDlc(oldDlc), HttpStatus.OK);
		}

		return new ResponseEntity<>("¡No existe un DLC con ID: " + idDlc + "!", HttpStatus.NOT_FOUND);
	}

	@DeleteMapping("/eliminar/{idDlc}")
	public ResponseEntity<?> eliminar(@PathVariable Integer idDlc) {

		if (service.findById(idDlc) != null) {
			service.delete(idDlc);
			return new ResponseEntity<>("DLC eliminado.", HttpStatus.OK);
		}

		return new ResponseEntity<>("¡No existe un DLC con ID: " + idDlc + "!", HttpStatus.NOT_FOUND);
	}
}
