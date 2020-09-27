package ar.com.educacionit.domain.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class AdministradorDeConexiones {
	
	public static Connection obtenerConexion() throws Exception
	{
	 // vi hasta la 2:17:41 de la clase 6
	        // Establece el nombre del driver a utilizar
	        // String dbDriver = "com.mysql.jdbc.Driver";
	        String dbDriver = "com.mysql.cj.jdbc.Driver";
	    	
	    	// Establece la url y base de datos a utilizar. "jdbc:mysql://" ->va siempre igual
	        // String dbConnString = "jdbc:mysql://localhost/jseweb";
	        String dbConnString = "jdbc:mysql://localhost:3306/jseweb?serverTimezone=UTC";
	    	
	    	// Establece el usuario de la base de datos
	        String dbUser = "root";
	       
	        // Establece la contrase�a de la base de datos
	        String dbPassword = "";
	       
	        // Establece el driver de conexion
	        Class.forName(dbDriver).newInstance(); // se crea una instancia del dbDriver
	       
	        // Retorna la conexion
	        Connection conn =  DriverManager.getConnection(dbConnString, dbUser, dbPassword);
	        return conn;
		}
	 


}
