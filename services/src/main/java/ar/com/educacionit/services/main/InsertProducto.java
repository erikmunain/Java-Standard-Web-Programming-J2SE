package ar.com.educacionit.services.main;

import ar.com.educacionit.domain.Producto;
import ar.com.educacionit.services.ProductoServices;
import ar.com.educacionit.services.ProductoServicesImpl;
import ar.com.educacionit.services.exceptions.ServiceException;

public class InsertProducto {

	public static void main(String[] args) {
		
		ProductoServices service = new ProductoServicesImpl();
		
		Producto p = new Producto("CELULAR LG", 9500f, "4");
		
		try {
			service.nuevoProducto(p);
		} catch (ServiceException e) {
			e.printStackTrace();
		}

	}

}
