package Controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Persona;
import modelo.PersonaDao;

/**
 * Servlet implementation class controlador
 */
@WebServlet("/controlador")
public class controlador extends HttpServlet {
	 Persona p= new Persona();
	PersonaDao dao= new PersonaDao();
	
	static final long serialVersionUID = 1L;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public controlador() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}


	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			
		// si el usuario pulsa el boton se carga la lista//
      String accion= request.getParameter("accion");
      
      switch (accion) {
      case "listar":
    	  List<Persona> datos = dao.listar();
    	  request.setAttribute("datos", datos);
    	  request.getRequestDispatcher("index.jsp").forward(request, response);
 
    	   break;
    	   
    	   
       case "Agregar":
    	   
    request.getRequestDispatcher("Agregar.jsp").forward(request, response);
    break;
    //metodo para guardar si el usuario presiona el boton aca lo redirecciona//
       case "guardar":
    	   // recibimos las variables
    	   String id=request.getParameter("txtid");
    	   String nom=request.getParameter("txtnom");
    	   String correo=request.getParameter("correo");
    	   String tele=request.getParameter("telefono");
           
            p.setId(id);
            p.setNom(nom);
            p.setCorreo(correo);
            p.setTele(tele);
            dao.agregar(p);
            //agregamos al metodo listar automaticamente al agregar//
            request.getRequestDispatcher("controlador?accion=listar").forward(request, response);
          break;
       case "Editar":
    	   
    	   //CARGAMOS LOS DATOS PARA ACTUALIZAR
    	   // RECIBIMOS EL ID DE LA PERSONA QUE VIENE DESDE LA SELECCION DE LA FILA
    	   String ide=request.getParameter("id");
    	   //llamo persona y le paso el mètodo
    	   Persona p= dao.listaId(ide);
    	   //para que se muestre en el formulario estamos el dato que almacena la variable
    	  request.setAttribute("persona", p);
    	   request.getRequestDispatcher("actualizar.jsp").forward(request, response);
           break;
       case  "Actualizar":
    	   //recibimos los parametros
    		 Persona pe= new Persona();
    	   String id1= request.getParameter("txtid");
    	   String nom1=request.getParameter("txtnom");
    	   String corre1=request.getParameter("correo");
    	   String tel1=request.getParameter("telefono");
    	   pe.setId(id1);
    	   pe.setNom(nom1);
    	   pe.setCorreo(corre1);
    	   pe.setTele(tel1);
    	   dao.actualizar(pe);
    	   request.getRequestDispatcher("controlador?accion=listar").forward(request, response);
      break;
      
      
       case "eliminar":
    	   String id2=request.getParameter("id");
    	   dao.delete(id2);

    	   request.getRequestDispatcher("controlador?accion=listar").forward(request, response);
          
      
      }
			
		
}}
