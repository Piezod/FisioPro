package Sv;


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
@WebServlet("/SvMenu")
public class SvMenu extends HttpServlet {
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
		
		if (request.getParameter("operacion").equalsIgnoreCase("alta"))
				{
						System.out.println("Voy a alta usuario.jsp desde sv menu");
						request.setAttribute("datos", "pantalla de alta usuario");
						request.getRequestDispatcher("WEB-INF/Cliente/AltaCliente.jsp").forward(request,response);
				}
		else if (request.getParameter("operacion").equalsIgnoreCase("baja"))
		{
			System.out.println("Voy a alta bajausuario.jsp");
		}
		else if (request.getParameter("operacion").equalsIgnoreCase("modificacion"))

		{
			System.out.println("Voy a alta modificacionusuario.jsp");
		}
	}
	

}
