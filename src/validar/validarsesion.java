package validar;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.usuario;

/**
 * Servlet implementation class validarsesion
 */
@WebServlet("/validarsesion")
public class validarsesion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public validarsesion() {
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
		// TODO Auto-generated method stub
		
		
		response.setContentType("text/html;charset=UTF-8");
		
		String rut ,pass;
		rut=request.getParameter("rut");
		pass=request.getParameter("pass");
		
		
		
		 /*validar usuario y pass*/
		
		if (rut.equalsIgnoreCase("1788888")) {
			
			if (pass.equalsIgnoreCase("123")){
				/*ok , usuario Correcto*/
				//le paso datos en un usuario ,lo creo
				
				usuario usu =new usuario(rut,pass);
				
				HttpSession sesion= request.getSession();
				sesion.setAttribute("usuario", usu);
				
				//forwad para que realmente se valla donde , si no esta forwad queda ahi
			   request.getRequestDispatcher("menuprincipal").forward(request, response);
				
			}else {/*pass Incorrecta*/
				
				 request.getRequestDispatcher("Error").forward(request, response);
				
			}
			
		}else {/*usuario Incorrecto */
			
			 request.getRequestDispatcher("Error").forward(request, response);
		}
		
		
		
		
		
		
		
		
	}

}
