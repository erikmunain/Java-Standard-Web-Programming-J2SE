package ar.com.educacionit.domain.main;
/*
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import ar.com.educacionit.domain.Producto;
import ar.com.educacionit.domain.jdbc.AdministradorDeConexiones;
*/
/*public class Main {

	public static void main(String[] args) {
		// obtener una conexión desde la clase
		try {
			Connection conection = AdministradorDeConexiones.obtenerConexion();
			// esto lo usé para chequear la conexión y tenía después solamente el "conection.close(); luego el catch
			//boolean alive = !conection.isClosed();
			// System.out.println(alive);
			
			Statement st = conection.createStatement();
			
			ResultSet rs =  st.executeQuery("SELECT * FROM producto"); // elegir el Resulset de java.sql 
			
			// obtener datos desde el rs:
			if (rs.next()) { // con el "next" le digo que ejecute lo que está dentro del if si hay algo
			
				Long id = rs.getLong(1); // elijo el getLong (columna label) y le indico la columna 1 que es de id. O sea que devuelva los datos que hay en la columna 1 y lo guarde en id que es un Long. La primera posición siempre es 1 (no 0 como en un array por ejemplo)
				String descripcion = rs.getString(2);
				Float precio = rs.getFloat(3);
				String codigo = rs.getString(4);
				
				Producto producto = new Producto(id, descripcion, precio, codigo);
				System.out.println(producto);
				
			}
			
			conection.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
*/