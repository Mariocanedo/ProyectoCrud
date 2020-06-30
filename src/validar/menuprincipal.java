package validar;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.usuario;

/**
 * Servlet implementation class menuprincipal
 */
@WebServlet("/menuprincipal")
public class menuprincipal extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public menuprincipal() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter salida=response.getWriter();
		//obtenemos el objeto sesion
		 HttpSession sesion =request.getSession();
		 //hacemos el import y transformamos con un casting
		 usuario usu = (usuario)sesion.getAttribute("usuario");


		 if (usu ==null) {
			 request.getRequestDispatcher("Error").forward(request, response);
		 }
		 else {
			 
		 
		  
		   salida.println("<html><body>");
		   
		   salida.println("<h1 style='text-align:center'>Bienvenido "+usu.getRut()+"</h1>");
			salida.println("");
			salida.println("");
			salida.println("");
			salida.println("<a href='login.html'>volver</a>");
			salida.println("<a href='cerrarsesion'>Cerar sesiòn</a>");
            salida.println("</html></body>");

	
	}
		 }
}
