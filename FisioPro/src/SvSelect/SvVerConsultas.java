package SvSelect;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import BLL.ClienteBLL;
import BLL.ConsultaBLL;
import Entidades.Cliente;
import Entidades.Consulta;
import Entidades.DetalleConsulta;
import Entidades.PreVerDetalleConsulta;
import Sv.SvBase;
import error.GenericException;

/**
 * Servlet implementation class SvVerConsultas
 */
@WebServlet("/SvVerConsultas")
public class SvVerConsultas extends SvBase {
	private static final long serialVersionUID = 1L;
    private String OPERACION;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SvVerConsultas() {
        super();
        // TODO Auto-generated constructor stub
    }

	@Override
	public void doProcess(HttpServletRequest request, HttpServletResponse response) throws GenericException, ServletException, IOException {
	
		OPERACION=request.getParameter("oper");
		
		if (OPERACION.equalsIgnoreCase("vercli"))
		{
			request.setAttribute("listacliente", buscarclientes());
			
			request.getRequestDispatcher("WEB-INF/Consulta/VerConsultas.jsp").forward(request,response);
		}else if (OPERACION.equalsIgnoreCase("detalleconsulta"))
		{
			
			request.setAttribute("detalleconsulta", listadopreviodetalleconsluta(request.getParameter("oid_cliente")));
			request.getRequestDispatcher("WEB-INF/Consulta/VerDetalleConsulta.jsp").forward(request,response);
		}else if ( OPERACION.equalsIgnoreCase("abriranamnesis"))
		{
			System.out.println(request.getParameter("oid_anamnesis"));
		}
	}
	
	/**
	 * Metodo para rellenar una lista que devuelva TODOS los clientes.
	 * 
	 * @return Lista con tdos los clientes y sus datos.
	 */
	private List<Cliente> buscarclientes()
	{
		ClienteBLL clibl=new ClienteBLL();
		return clibl.RecargarTodosCliente();
	}

	private List<DetalleConsulta> recargarconsulta(String idcliente)
	{
		System.out.println(idcliente);
		ConsultaBLL consulbll=new ConsultaBLL(idcliente);
		
		return consulbll.rellenarconsultaporcliente();
		
	}
	
	private List<PreVerDetalleConsulta> listadopreviodetalleconsluta(String idcliente)
	{
		System.out.println(idcliente);
		ConsultaBLL consulbll=new ConsultaBLL(idcliente);
		return consulbll.preverdetalleconsultas();
		
	}
}
