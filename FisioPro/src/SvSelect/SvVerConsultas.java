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

import BD.TratamientoDAL;
import BLL.AnamnesisBLL;
import BLL.ClienteBLL;
import BLL.ConsultaBLL;
import BLL.ExploracionBLL;
import BLL.TratamientoBLL;
import Entidades.Anamnesis;
import Entidades.Cliente;
import Entidades.Consulta;
import Entidades.DetalleConsulta;
import Entidades.Exploracion;
import Entidades.PreVerDetalleConsulta;
import Entidades.Tratamiento;
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
			   String json = new Gson().toJson(verfrmanamnesis(request.getParameter("oid_anamnesis")));
			    response.setContentType("application/json");
			    response.setCharacterEncoding("UTF-8");
			    System.out.println("Devolviendo el objeto a json"+json);
			    response.getWriter().write(json);
		}
		else if ( OPERACION.equalsIgnoreCase("abrirexploracion"))
		{		
			   String json = new Gson().toJson(verfrmexploracion(request.getParameter("oid_exploracion")));
			    response.setContentType("application/json");
			    response.setCharacterEncoding("UTF-8");
			    System.out.println("Devolviendo el objeto a json"+json);
			    response.getWriter().write(json);
		}else if ( OPERACION.equalsIgnoreCase("abrirtratamiento"))
		{		
			   String json = new Gson().toJson(verfrmtratamiento(request.getParameter("oid_tratamiento")));
			    response.setContentType("application/json");
			    response.setCharacterEncoding("UTF-8");
			    System.out.println("Devolviendo el objeto a json"+json);
			    response.getWriter().write(json);
		}else
		{
			System.out.println("no existe ese jsp");
			request.getRequestDispatcher("inicio.jsp").forward(request,response);
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

	/**Devuelve un objeto bean relleno con la informacion del formulario anamnesis
	 * @param oid_anamnesis la id del formulario de la cual tenemos que extraer informacion
	 * @return Retorna objeto Anamnesis
	 */
	private Anamnesis verfrmanamnesis(String oid_anamnesis)
	{
		Anamnesis anam=new Anamnesis();
		anam.setOid_anamnesis(Integer.parseInt(oid_anamnesis));
		AnamnesisBLL anambll=new AnamnesisBLL(anam);
		return anambll.rellenaranamnesis();
	}

	private Exploracion verfrmexploracion(String oid_exploracion)
	{
		Exploracion anam=new Exploracion();
		anam.setOid_exploración(Integer.parseInt(oid_exploracion));
		ExploracionBLL anambll=new ExploracionBLL(anam);
		return anambll.RellenarExploracion();
	}
	
	private Tratamiento verfrmtratamiento(String oid_tratamiento)
	{
		Tratamiento tra=new Tratamiento();
		tra.setOid_tratamiento((Integer.parseInt(oid_tratamiento)));
		TratamientoBLL trabll=new TratamientoBLL(tra);
		return trabll.RellenarTratamiento();
	}


}
