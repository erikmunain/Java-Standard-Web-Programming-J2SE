package ar.com.educacionit.services;

import java.util.Collection;

import ar.com.educacionit.domain.Producto;
import ar.com.educacionit.services.exceptions.ServiceException;

public interface ProductoServices {
	
	public Collection<Producto> findProductos() throws ServiceException; // devuelve una colección de productos
	
	public void eliminarProducto(Long id) throws ServiceException;
	
	public Producto nuevoProducto(Producto producto) throws ServiceException;

	public void actualizarProducto(Producto aux) throws ServiceException;

	public Producto obtenerProducto(Long id) throws ServiceException;

	
}
