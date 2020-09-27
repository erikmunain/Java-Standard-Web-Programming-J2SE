package ar.com.educacionit.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import ar.com.educacionit.dao.exceptions.DuplicatedException;
import ar.com.educacionit.dao.exceptions.GenericException;
import ar.com.educacionit.domain.Producto;
import ar.com.educacionit.domain.jdbc.AdministradorDeConexiones;

public class ProductoDAOJDBCImpl implements ProductoDAO {

	public Collection<Producto> findProductos() throws GenericException  {
			
			Collection<Producto> productos = new ArrayList<Producto>();
				
		try {
			Connection conection = AdministradorDeConexiones.obtenerConexion();
			// esto lo usé para chequear la conexión y tenía después solamente el "conection.close(); luego el catch
			//boolean alive = !conection.isClosed();
			// System.out.println(alive);
			
			Statement st = conection.createStatement();
											
			// volver a consultar, pero ahora todos los productos:
			ResultSet rs =  st.executeQuery("SELECT * FROM producto");
			
			Producto producto = null;
			
			// obtener datos desde el rs:
			while (rs.next()) { // con el "next" le digo que ejecute lo que está dentro del if si hay algo
			
				Long id = rs.getLong(1); // elijo el getLong (columna label) y le indico la columna 1 que es de id. O sea que devuelva los datos que hay en la columna 1 y lo guarde en id que es un Long. La primera posición siempre es 1 (no 0 como en un array por ejemplo)
				String descripcion = rs.getString(2);
				Float precio = rs.getFloat(3);
				String codigo = rs.getString(4);
				
				producto = new Producto(id, descripcion, precio, codigo);
				productos.add(producto);
			}
			
			conection.close();
			
			return productos;
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new GenericException(e.getMessage(), e);
		}
		
		
	}
	


	public void deleteProducto(Long id) throws GenericException{ // este es un método que borra un producto
		
			Connection connection = null;
			Statement st = null;
		try {
			
			connection = AdministradorDeConexiones.obtenerConexion();
			
			connection.setAutoCommit(false);
			
			st = connection.createStatement();
		
			int rows = st.executeUpdate("DELETE FROM producto where id = " + id);
			
			if (rows > 0) {			
			
				connection.commit();
			} else {
				throw new GenericException("No existe el producto con id= " + id, null); // le agregué el null porque sino tiraba error
			}
			
	
			
		} catch (Exception e) {
					
			try {
				connection.rollback(); // el rollback hay que try cachearlo
			} catch (SQLException e1) {
				throw new GenericException(e1.getMessage(), e1);
			}

		} finally {
			try{
				st.close();
				connection.close();
				
			}catch (SQLException e) {
				throw new GenericException(e.getMessage(), e);
			}
		}
	}

	
	@Override
	public Producto insertProducto(Producto producto) throws DuplicatedException, GenericException {
		
		Connection connection = null;
		Statement st = null;
	try {
		
		connection = AdministradorDeConexiones.obtenerConexion();
		
		connection.setAutoCommit(false);
		
		st = connection.createStatement();
	
		int rows = st.executeUpdate("INSERT INTO producto (DESCRIPCION, PRECIO, CODIGO) VALUES ('"+ producto.getDescripcion()+"', "+producto.getPrecio()+" , "+producto.getCodigo()+")");                                   
		
		connection.commit();
		
		
			
	} catch (Exception e) {
				
		try {
			connection.rollback(); // el rollback hay que try cachearlo
		} catch (SQLException e1) {
			throw new GenericException(e1.getMessage(), e1);
		}

	} finally {
		try{
			st.close();
			connection.close();
		}catch (SQLException e) {
			throw new GenericException(e.getMessage(), e);
		}
	}
	return producto;	
	}



	@Override
	public Producto insertProducto() throws DuplicatedException, GenericException {
		
		return null;
	}



	@Override
	public Producto updateProducto(Producto producto) throws DuplicatedException, GenericException {
		
		Connection connection = null;
		Statement st = null;
	try {
		
		connection = AdministradorDeConexiones.obtenerConexion();
		
		connection.setAutoCommit(false);
		
		st = connection.createStatement();
	
		int rows = st.executeUpdate("UPDATE producto SET precio="+producto.getPrecio()+" , descripcion='"+producto.getDescripcion()+"'  WHERE id="+producto.getId()+"" );                                   
		
		connection.commit();
		
		
			
	} catch (Exception e) {
				
		try {
			connection.rollback(); // el rollback hay que try cachearlo
		} catch (SQLException e1) {
			throw new GenericException(e1.getMessage(), e1);
		}

	} finally {
		try{
			st.close();
			connection.close();
		}catch (SQLException e) {
			throw new GenericException(e.getMessage(), e);
		}
	}
	return producto;
		
		
		
	}

	
	public Producto getProducto (Long id) throws GenericException { 
		
		Producto producto = null;
		
		Connection connection = null;
		Statement st = null;
		
		
		try {
			connection = AdministradorDeConexiones.obtenerConexion();
					
			st = connection.createStatement();
			
			ResultSet rs = st.executeQuery("SELECT * FROM producto where id = " + id);
			
			
			
			int i = 0;
			if (rs.next()) { 
			
				Long idAux = rs.getLong(1); 
				String descripcion = rs.getString(2);
				Float precio = rs.getFloat(3);
				String codigo = rs.getString(4);
				
				producto = new Producto(idAux, descripcion, precio, codigo);
			}
			
			return producto;
			
		 } catch (Exception e) {
			
			 try {
				 connection.rollback();
				 throw new GenericException(e.getMessage(), e);
			 } catch (SQLException e1) {
				 throw new GenericException(e1.getMessage(), e1);
			 }

		 } finally {
			 try{
				 st.close();
				 connection.close();
			 }catch (SQLException e) {
				 throw new GenericException(e.getMessage(), e);
			 }
		 }
	}


}

