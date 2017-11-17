package Sv;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
			if (request.getParameter("operacion").equalsIgnoreCase("alta"))
			{
				
				System.out.println("Voy a alta cliente");
				crearcliente(request);
				request.setAttribute("datos", "pantalla de alta usuario");
				request.getRequestDispatcher("WEB-INF/AltaCliente.jsp").forward(request,response);
			}
			else if (request.getParameter("operacion").equalsIgnoreCase("baja"))
			{
				System.out.println("Voy a alta baja cliente.jsp");
			}
			else if (request.getParameter("operacion").equalsIgnoreCase("modificacion"))
			
			{
				System.out.println("Voy a alta modificacion cliente.jsp");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}			
		
		
	}
	
	protected void crearcliente(HttpServletRequest request) throws Exception
	{
		ClienteBLL cli=new ClienteBLL(
				request.getParameter("nombre")
				,request.getParameter("apellido1")
				,request.getParameter("apellido2")
				,request.getParameter("edad")
				,request.getParameter("telefono")
				);
		if(	cli.altacliente())
		{
			System.out.println("alta cliente ok");
		}
		else
		{
			System.err.println("error en alta cliente");
		}
	}

}
