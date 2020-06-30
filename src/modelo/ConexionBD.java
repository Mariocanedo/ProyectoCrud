package modelo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {
	//la ruta del motor donde la busca
// nombew de la base de datos
private final String stringConexion = "jdbc:oracle:thin:@localhost:1521:xe";
	
	//Metodo para acceder a la BD
	 public Connection  conectar(){
		Connection conexion = null;
		//Metodo para acceder a la BD

			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				conexion = DriverManager.getConnection(stringConexion, "persona1","12345");
			} catch (ClassNotFoundException e) {
				System.out.println("No se encuentra el driver"+e.getMessage());
			}
			catch(SQLException e){
				System.out.println("Error en la conexión");
			}
			return conexion;
		}

		public static void main(String[] args) {
			if(new ConexionBD().conectar()!=null){
				System.out.println("Conexión exitosa");
			}
			else{
				System.out.println("Conexión fallida");
			}
		}
	}
 

 
	
		
		
		
		
	

	
	
	
	
	
	


	
