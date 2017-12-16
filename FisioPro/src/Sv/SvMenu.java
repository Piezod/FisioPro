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
	private static String OPERACION ;
       

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
		OPERACION=request.getParameter("oper");
		
		if (OPERACION.equalsIgnoreCase("alta"))
				{
						System.out.println("Voy a alta cliente");
						request.setAttribute("datos", "pantalla de alta usuario");
						request.getRequestDispatcher("WEB-INF/AltaCliente/AltaCliente.jsp").forward(request,response);
				}
		else if (OPERACION.equalsIgnoreCase("baja"))
		{
			System.out.println("Voy a alta bajausuario.jsp");
		}
		else if (OPERACION.equalsIgnoreCase("modificacion"))

		{
			System.out.println("Voy a alta modificacionusuario.jsp");
		}else
		{
			System.out.println("no existe ese jsp");
			request.getRequestDispatcher("inicio.jsp").forward(request,response);
		}
	}
	

}
