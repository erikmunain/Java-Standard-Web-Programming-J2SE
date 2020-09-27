package ar.com.educacionit.services.main;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.TreeSet;


import ar.com.educacionit.domain.Producto;
import ar.com.educacionit.services.ProductoServices;
import ar.com.educacionit.services.ProductoServicesImpl;
import ar.com.educacionit.services.collections.ComparadorProductoXDescripcion;
import ar.com.educacionit.services.exceptions.ServiceException;

public class FiltradoMain {

	public static void main(String[] args) throws ServiceException {
		
		ProductoServices ps = new ProductoServicesImpl();
		
		Collection<Producto> pds = ps.findProductos();
		
		// quiero filtrar los repetidos por descripcion: 
		
		TreeSet<Producto> pdsFiltrado = new TreeSet<Producto>(new ComparadorProductoXDescripcion());
		
		// agrego los productos
		
		pdsFiltrado.addAll(pds);
		
		System.out.println(pds);
		
		System.out.println(pdsFiltrado);
		
		boolean disjoin = Collections.disjoint(pds, pdsFiltrado);
		System.out.println(disjoin);
		
		// update sobre la DB utilizando los objetos de mi colección:
		Iterator<Producto> itProductos = pdsFiltrado.iterator();
		
		// se incrementa un 15% el precio
		// descripcion -> Título Del Producto
		while(itProductos.hasNext()) {
			Producto aux = itProductos.next();
			
			Float precioActual = aux.getPrecio();
			Float nuevoprecio = precioActual * 1.15f;
			aux.setPrecio(nuevoprecio);
			aux.setDescripcion(getDescripcionNueva(aux.getDescripcion()));
			
			// invoco al update de mi service:
			ps.actualizarProducto(aux);
			
		}
		
		System.out.println("Actualización finalizada");
		
	}
	
	public static String getDescripcionNueva (String descripcionOriginal) {
		String primerLetra = descripcionOriginal.substring(0, 1);
		String resto = descripcionOriginal.substring(1, descripcionOriginal.length());
		return primerLetra.toUpperCase() + resto.toLowerCase();
	}

}
