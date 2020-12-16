package pe.company.controller;

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

import pe.company.model.Producto;
import pe.company.service.ProductoService;
import pe.company.util.MapperUtil;

@RestController
@RequestMapping("/producto")
public class ProductoRestController 
{
	@Autowired
	private ProductoService productoService;
	
	@GetMapping("/listar")
	public ResponseEntity<?> listar_GET() 
	{
		Collection<Producto> itemsProducto=productoService.findAll();
		
		if(itemsProducto.isEmpty()) {
			return new ResponseEntity<>("¡Lista vacía!",HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<>(MapperUtil.convertProductoColl(itemsProducto),HttpStatus.OK);
	}
	
	@PostMapping("/registrar")
	public ResponseEntity<?> registrar(@RequestBody Producto producto){
		productoService.insert(producto);
		return new ResponseEntity<>("¡Producto registrado!",HttpStatus.CREATED);
	}
	
	@PutMapping("/editar/{idProducto}")
	public ResponseEntity<?> editar(@PathVariable Integer idProducto, @RequestBody Producto producto){
		Producto productoDb = productoService.findById(idProducto);
		
		if(productoDb!=null) {
			productoDb.setNombre(producto.getNombre());
			productoDb.setPrecio(producto.getPrecio());
			productoDb.setStock(producto.getStock());
			
			productoService.update(productoDb);
			return new ResponseEntity<>("¡Actualizado!",HttpStatus.OK);
		}
		
		return new ResponseEntity<>("¡No existe producto!",HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("/eliminar/{idProducto}")
	public ResponseEntity<?> eliminar(@PathVariable Integer idProducto){
Producto productoDb = productoService.findById(idProducto);
		
		if(productoDb!=null) {
			productoService.delete(idProducto);
			return new ResponseEntity<>("¡Eliminado!",HttpStatus.OK);
		}
		
		return new ResponseEntity<>("¡No existe producto!",HttpStatus.NOT_FOUND);
	}
}
