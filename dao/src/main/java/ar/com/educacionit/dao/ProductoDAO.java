package ar.com.educacionit.dao;

import java.util.Collection;

import ar.com.educacionit.dao.exceptions.DuplicatedException;
import ar.com.educacionit.dao.exceptions.GenericException;
import ar.com.educacionit.domain.Producto;
//import ar.com.educacionit.services.exceptions.ServiceException;

public interface ProductoDAO {
	
	public Collection<Producto> findProductos() throws GenericException; // busca productos

	public void deleteProducto(Long id) throws GenericException; // elimina un producto por Primary key
	
	public Producto insertProducto() throws DuplicatedException, GenericException;

	Producto insertProducto(Producto producto) throws DuplicatedException, GenericException;
	
	public Producto updateProducto (Producto producto) throws DuplicatedException, GenericException;

	public Producto getProducto(Long id) throws GenericException;

}
