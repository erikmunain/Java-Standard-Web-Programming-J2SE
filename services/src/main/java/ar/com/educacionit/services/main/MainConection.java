package ar.com.educacionit.services.main;

import ar.com.educacionit.domain.Producto;
import ar.com.educacionit.services.ProductoDAO;
import ar.com.educacionit.services.ProductoDAOJDBCImpl;

public class MainConection {

	public static void main(String[] args) {
		// interfaz i = new Clase();
		
		ProductoDAO pdao = new ProductoDAOJDBCImpl();
		
		Producto producto = pdao.getProducto();
		
		System.out.println(producto);

	}

}
