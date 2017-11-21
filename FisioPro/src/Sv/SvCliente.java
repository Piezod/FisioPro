package Sv;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BLL.AntecedentesPersonalesBLL;
import BLL.ClienteBLL;
import Entidades.Cliente;

/**
 * Servlet implementation class SvCliente
 */
@WebServlet("/SvCliente")
public class SvCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SvCliente() {
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
		try {
			if (request.getParameter("oper").equalsIgnoreCase("alta"))
			{
				ClienteBLL cli=new ClienteBLL(request.getParameter("nombre")
						,request.getParameter("apellido1")
						,request.getParameter("apellido2")
						,request.getParameter("edad")
						,request.getParameter("telefono"));
				int idcliente=crearcliente(cli);
						
				/*
				 *  Si tenemos id cliente se ha producido el alta y pasamos al formulario de 
				 *  antecedentes personales
				 */
				if (idcliente>0)
				{
					request.setAttribute("idcliente",idcliente);
					request.getRequestDispatcher("WEB-INF/AntecedentesPersonales.jsp").forward(request,response);
				}
				else
				{
					throw new Exception("excepcion mia, no se dio de alta el cliente");
				}
				
			}
			else if (request.getParameter("oper").equalsIgnoreCase("baja"))
			{
				System.out.println("Voy a alta baja cliente.jsp");
			}
			else if (request.getParameter("oper").equalsIgnoreCase("modificacion"))
			
			{
				System.out.println("Voy a alta modificacion cliente.jsp");
			}else if (request.getParameter("oper").equalsIgnoreCase("antecedentespersonales"))
			{
				System.out.println("Antecedentes personales id cliente "+ request.getParameter("oid_cliente"));
				AntecedentesPersonalesBLL ap=new AntecedentesPersonalesBLL(
						request.getParameter("oid_cliente")
						,request.getParameter("eg")
						,request.getParameter("oq")
						,request.getParameter("tma")
						,request.getParameter("la")						
						);
				int id=crearantecedente(ap);
				if (id>0)
				{
					request.setAttribute("exito",id);
					request.setAttribute("tipo","Alta Cliente");
					//response.sendRedirect("inicio.jsp");
					request.getRequestDispatcher("inicio.jsp").forward(request,response);
				}
				else
				{
					throw new Exception("excepcion mia, no se dio de alta los antecedentes");
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}			
		
	}
	
	protected int crearcliente(ClienteBLL cli) throws Exception
	{
		return cli.altacliente();
	}
	
	private int crearantecedente(AntecedentesPersonalesBLL ap) {
		// TODO Auto-generated method stub
		return ap.altaantecedentes();
	}

}
