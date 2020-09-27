package ar.com.educacionit.services.collections;

import java.util.Comparator;

import ar.com.educacionit.domain.Producto;

public class ComparadorProductoXDescripcion implements Comparator<Producto>{

	@Override
	public int compare(Producto p1, Producto p2) {
		
		// logica de comparacion
		
		p1.getDescripcion().compareTo(p2.getDescripcion());
		
		
		return 0;
	}
	
	

}
