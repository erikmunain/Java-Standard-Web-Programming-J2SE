package ar.com.educacionit.services;

import java.util.Collection;

import ar.com.educacionit.dao.ProductoDAO;
import ar.com.educacionit.dao.ProductoDAOJDBCImpl;
import ar.com.educacionit.dao.exceptions.DuplicatedException;
import ar.com.educacionit.dao.exceptions.GenericException;
import ar.com.educacionit.domain.Producto;
import ar.com.educacionit.services.exceptions.ServiceException;

public class ProductoServicesImpl implements ProductoServices {
	
	// interfaz
	private ProductoDAO productoDao;
	
	// CTRL + SPACE y nos aparece una lista. Entre los elementos figura el constructor que pusimos:
	public ProductoServicesImpl() {
		this.productoDao = new ProductoDAOJDBCImpl(); // acá le indico que a esta interfaz "ProductoDao" le asigno una instancia de "ProductoDAOJDBCImpl" 
	}
	
	public Collection<Producto> findProductos() throws ServiceException{
		// CTRL + SHIFT + O -> borra los imports que quedaron de la otra clase. Esto hay que hacerlo cuando cambiamos el nombre o copiamos una clase o interfaz
		try{
			return this.productoDao.findProductos();
		} catch (GenericException e) {
			e.printStackTrace();
			throw new ServiceException(e.getMessage(), e);
		}
	}

	@Override
	public void eliminarProducto(Long id) throws ServiceException {
		try {
			this.productoDao.deleteProducto(id);
		} catch (GenericException e) {
			e.printStackTrace();
			throw new ServiceException(e.getMessage(), e);
		}
		
	}
		// CTRL + SPACE (nos da la opción de poner lo que está abajo:
		@Override
		public Producto nuevoProducto(Producto producto) throws ServiceException {
			
			try {
				return this.productoDao.insertProducto(producto);
			} catch (DuplicatedException | GenericException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new ServiceException(e.getMessage(),e);
			}
			
			
			
		}

		@Override
		public void actualizarProducto(Producto producto) throws ServiceException {
			try {
				this.productoDao.updateProducto(producto);
			} catch (DuplicatedException | GenericException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new ServiceException(e.getMessage(),e);
			}
			
		}

		@Override
		public Producto obtenerProducto(Long id) throws ServiceException {
			try {
				return this.productoDao.getProducto(id);
			} catch (GenericException e) {
				e.printStackTrace();
				throw new ServiceException(e.getMessage(),e);
			}
		}
		
}

// Con todo este código hice que esto sea una capa de services. Por medio de la interface "ProductoServicesImpl" consume productos que están en el proyecto "dao" 