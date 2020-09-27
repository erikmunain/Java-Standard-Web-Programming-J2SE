package ar.com.educacionit.services.main;

import ar.com.educacionit.domain.Producto;
import ar.com.educacionit.services.ProductoServices;
import ar.com.educacionit.services.ProductoServicesImpl;
import ar.com.educacionit.services.exceptions.ServiceException;

public class UpdateProducto {

	public static void main(String[] args) throws ServiceException {
		ProductoServices service = new ProductoServicesImpl();
					
		Producto aux = service.obtenerProducto(1L) ;
		
		System.out.println(aux);
		
		// update del objeto:
		aux.setDescripcion(aux.getDescripcion() + " modificada");
		aux.setPrecio(aux.getPrecio() + 100);
		
		service.actualizarProducto(aux);
			
		aux = service.obtenerProducto(aux.getId());
		
		System.out.println(aux);
		
		
	}

}
	

