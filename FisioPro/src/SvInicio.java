

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import BD.Conexion;
import BLL.LoginBLL;
import Entidades.Usuario;

/**
 * Servlet implementation class SvInicio
 */
@WebServlet("/SvInicio")
public class SvInicio extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		try {
			if (request.getParameter("operacion").equalsIgnoreCase("login"))
					{
						login(request.getParameter("usuario"),request.getParameter("pass"),request,response);
					}
			else if (request.getParameter("operacion").equalsIgnoreCase("recordar"))
			{
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	//metodo para ver si el login es correcto o no al recogerlo desde la jsp login
		private void login(String usuario, String pass,HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException
		{
			Usuario user=new Usuario();
			LoginBLL lg=new LoginBLL(user);
			if (lg.comprobarlogin(usuario, pass))
					{
				request.setAttribute("usuario", user);
				request.getRequestDispatcher("WEB-INF/inicio.jsp").forward(request,response);
					}
			else
			{		
				request.setAttribute("datos", "caca");
				request.getRequestDispatcher("Login.jsp").forward(request,response);			
			}
		}
}
