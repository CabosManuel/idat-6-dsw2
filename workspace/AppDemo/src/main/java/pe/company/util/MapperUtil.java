package pe.company.util;

import java.util.ArrayList;
import java.util.Collection;

import pe.company.mapper.ProductoMapper;
import pe.company.model.Producto;

public class MapperUtil {
	
	public static Collection<ProductoMapper> convertProductoColl(Collection<Producto> productos){
		
		Collection<ProductoMapper> prodcutosMapper = new ArrayList<>();
		
		for(Producto producto:productos) {
			ProductoMapper mapper = new ProductoMapper(producto);
			prodcutosMapper.add(mapper);
		}
		
		return prodcutosMapper;
	}
}
