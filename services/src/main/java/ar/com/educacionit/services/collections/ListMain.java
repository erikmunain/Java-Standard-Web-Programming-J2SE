package ar.com.educacionit.services.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListMain {

	public static void main(String[] args) {
	
		// COLECCIONES
		// interfaz i = new clase();
		
		
		// lo que hice del lado izquierdo del igual se llama "tipar" o parametrizar una colección
		List<Integer> lista2 = new ArrayList<>();
		
		// cargar una lista:
		lista2.add(10);
		lista2.add(20);
		lista2.add(30);
		
		lista2.add(30);
		lista2.add(40);
		
		//recorro la lista:
		Iterator<Integer> listaEnteros = lista2.iterator(); // del lado izquierdo tengo una interface que guarda enteros y del lado derecho tengo una interface que me devuelve otra interface

		// con while:
		while(listaEnteros.hasNext()) {
			
			Integer valor = listaEnteros.next();
			
			System.out.println(valor);
		}
		
		// elimino un elemento de una colección:
		
		listaEnteros = lista2.iterator(); // Esto lo hago porque al haber usado el iterator de la fila 27, me quedó en el último elemento de la lista. Con este código lo vuelvo a colocar en el primer elemento de la lista, así puedo volver a usar el "iterator"
		
		while(listaEnteros.hasNext()) {
			Integer valor = listaEnteros.next(); 
			listaEnteros.remove();
			
			System.out.println(valor);
		}
		
		
	}

}
