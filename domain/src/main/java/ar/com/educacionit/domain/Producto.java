 /* Esto lo dejó a las 21:15 en la clase del 3/6/2020:
  
 String dbDriver = "com.mysql.jdbc.Driver";
			String dbDriver = "com.mysql.cj.jdbc.Driver";
	    	
	    	// Establece la url y base de datos a utilizar
	        //String dbConnString = "jdbc:mysql://localhost/jseweb";
	        String dbConnString = "jdbc:mysql://localhost:3306/jseweb?serverTimezone=UTC";



*/

/* Esto lo dejó a las 21:27 en la clase del 3/6/2020:
 
Connection conection = AdministradorDeConexiones.obtenerConexion();
			
			Statement st = conection.createStatement();
			
			ResultSet rs = st.executeQuery("SELECT * FROM producto");
			
			//obtener los datos desde el rs
			Long id = rs.getLong(1);
			
			System.out.println("Valor obtenido = " +id);
			
			conection.close();

*/


package ar.com.educacionit.domain;

public class Producto {
	
	private Long id;
	private String descripcion;
	private Float precio;
	private String codigo;
	
	
	
	@Override
	public String toString() {
		return "Producto [id=" + id + ", descripcion=" + descripcion + ", precio=" + precio + ", codigo=" + codigo
				+ "]";
	}

	public Producto(String descripcion, Float precio, String codigo) {
		this.descripcion = descripcion;
		this.precio = precio;
		this.codigo = codigo;
	}

	public Producto(Long id, String descripcion, Float precio, String codigo) {
		this.id = id;
		this.descripcion = descripcion;
		this.precio = precio;
		this.codigo = codigo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Float getPrecio() {
		return precio;
	}

	public void setPrecio(Float precio) {
		this.precio = precio;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	

	
	
}
