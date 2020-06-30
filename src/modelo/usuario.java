package modelo;

public class usuario {
	
	private String rut;
	public usuario(String rut, String pass) {
		super();
		this.rut = rut;
		this.pass = pass;
	}
	
	private String pass;
	public String getRut() {
		return rut;
	}
	public void setRut(String rut) {
		this.rut = rut;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}

}
