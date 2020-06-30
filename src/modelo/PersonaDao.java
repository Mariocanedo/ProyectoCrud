
package modelo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class PersonaDao {
	
	//Declaramos las siguientes variables
	
	PreparedStatement ps;
	ResultSet rs;
	// hace referencia a la clase coneccion
	ConexionBD c= new ConexionBD();
	Connection con;
	
	//metodo para listar*/
//agrego por defaut el persona 
	public List<Persona> listar() {
		List<Persona>lista= new ArrayList<>();
		
		String sql="SELECT * FROM persona order by Id";
		try {
		
		con = c.conectar();
		ps= con.prepareStatement(sql);
		rs=ps.executeQuery();
		
		while(rs.next()) {
			Persona p= new Persona();
			p.setId(rs.getString(1));
			p.setNom(rs.getString(2));
			p.setCorreo(rs.getString(3));
			p.setTele(rs.getString(4));
			lista.add(p);
		}
	}catch (Exception e) {
		
	}return lista;
	
	}
	
	
	
	//metodo para agregar desde aca vamoa al controlador al segundo caso/
	public  int agregar(Persona p) {
		int r=0;
		
		
		  String query = "INSERT INTO persona (Id, nombre, correo, telefono) values (?, ?, ?, ?)";
		try {
			
			con= c.conectar();
			ps=con.prepareStatement(query);
			
			ps.setString(1, p.getId());
			ps.setString(2, p.getNom());
			ps.setString(3, p.getCorreo());
			ps.setString(4, p.getTele());
			r=ps.executeUpdate();
			if(r==1) {
				r=1;
			}else {
				r=0;
			}
			
			
		}catch(Exception e) {
			
		}
		return r;
		
		
		
	}
	
	// listamos solo la persona con el id que recibe como parametro
	public Persona listaId(String id) {
		
		String sql="Select * from persona where Id="+id;
		Persona p= new Persona();

		try {
			con=c.conectar();
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				p.setId(rs.getString(1));
				p.setNom(rs.getString(2));
				p.setCorreo(rs.getString(3));
				p.setTele(rs.getString(4));
			}
			
		}catch(Exception e) {} return p;
		
		
	}
	
	// recibe como parametro la persona con el id entregado
	
	public int actualizar(Persona pe) {
		//variable en cero, si update hace algo sera 1 
		int r=0;
		String sql="update persona set nombre=?,correo=?,telefono=? where Id=?";
	try {
		con=c.conectar();
		
		ps=con.prepareStatement(sql);
		//estamos seteando valore y se los pasamos a las colunas de la base de datos
		ps.setString(1,pe.getNom());
		ps.setString(2,pe.getCorreo());
		ps.setString(3,pe.getTele());
		ps.setString(4,pe.getId());
		r=ps.executeUpdate();
		if(r==1) {
			r=1;} else
			{ r=0;}
		
	}catch(Exception e) {}return r;
	
	
	
	}
	
	public void delete(String id) {
		
		String sql="delete from persona where Id="+id;
		
		try { con =c.conectar();
	   ps=con.prepareStatement(sql);
		ps.executeUpdate();
	} catch(Exception e) {}
	
	
	
	
}}
	
	
	
	
	
	
	
	
	
	
		
	
