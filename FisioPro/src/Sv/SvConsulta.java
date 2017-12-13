package Sv;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Request;

import com.google.gson.Gson;

import BD.NaturalezaDAL;
import BLL.AnamnesisBLL;
import BLL.AntecedentesPersonalesBLL;
import BLL.ClienteBLL;
import BLL.ConsultaBLL;
import BLL.NaturalezaBLL;
import BLL.TratamientoBLL;
import BLL.ExploracionBLL;
import Entidades.Anamnesis;
import Entidades.Cliente;
import Entidades.Consulta;
import Entidades.Exploracion;
import Entidades.NaturalezaDelDolor;
import Entidades.Tratamiento;

/**
 * Servlet implementation class SvConsulta
 */
@WebServlet("/SvConsulta")
public class SvConsulta extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Consulta consulta;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SvConsulta() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		 /*
		  * Ojo alta consulta luego tiene que decir si es nueva ( nueva consulta desde 0 )
		  * seguimiento ( es un alta consulta pero estara relacionada con una anterior)
		  */
		
		try {
			if (request.getParameter("oper").equalsIgnoreCase("alta"))
			{
				System.out.println("Voy a tramitar una consulta para "+request.getParameter("cliente"));
					request.setAttribute("cliente",request.getParameter("cliente"));
					request.getRequestDispatcher("WEB-INF/Consulta/AltaConsulta.jsp").forward(request,response);
			}			
		else if (request.getParameter("oper").equalsIgnoreCase("VerConsultas"))
		{
			System.out.println("Voy a alta  VerConsultas.jsp");
			request.setAttribute("idcliente",request.getParameter("cliente"));
			request.getRequestDispatcher("WEB-INF/Consulta/VerConsulta.jsp").forward(request,response);
	
		}
		else if (request.getParameter("oper").equalsIgnoreCase("nueva"))
		{
			System.out.println("Voy a alta  NuevaConsulta.jsp"+request.getParameter("cliente"));	
			consulta=new Consulta();
			consulta.setMotivo("Nueva");
			consulta.setOid_cliente(Integer.parseInt(request.getParameter("cliente")));
			request.setAttribute("cliente",request.getParameter("cliente"));
			request.getRequestDispatcher("WEB-INF/Consulta/NuevaConsulta.jsp").forward(request,response);
		}
		else if (request.getParameter("oper").equalsIgnoreCase("naturaleza"))
		{		
			
			System.out.println("Alta formulario anamnesis \n para el cliente con id "+request.getParameter("cliente"));
			if (altaformularioanamnesis(request, request.getParameter("cliente"))>0)
			{
			request.setAttribute("cliente",request.getParameter("cliente"));
			consulta.setOid_anamnesis((obtenerultimaidanamnesis()));
			request.getRequestDispatcher("WEB-INF/Consulta/Naturaleza.jsp").forward(request,response);
			}
			else
			{
				request.setAttribute("cliente",request.getParameter("cliente"));
				request.getRequestDispatcher("WEB-INF/Consulta/NuevaConsulta.jsp").forward(request,response);
			}
		}
		else if (request.getParameter("oper").equalsIgnoreCase("exploracion"))
		{
			if (altanaturaleza(request)>0)
			{
			
			  request.getRequestDispatcher("WEB-INF/Consulta/Exploracion.jsp").forward(request,response);
			}
		}
		else if (request.getParameter("oper").equalsIgnoreCase("tratamiento"))
		{
			if (altaexploracion(request)>0)
			{
				consulta.setOid_exploración(obtenerultimaidExploracion());
				request.getRequestDispatcher("WEB-INF/Consulta/tratamiento.jsp").forward(request,response);
			}
		}
		else if (request.getParameter("oper").equalsIgnoreCase("consulta"))
		{
			/*
			 * Logica de alta de consulta
			 */
			if (altatratamiento(request)>0)
			{
				consulta.setOid_tratamiento(ObtenerUltimaIdTratamiento());
				String mensaje="<div class=\"alert alert-info\"><strong>Consulta dada de ALTA</strong style=\"margin : 5px\"></div>";
				
				request.setAttribute("exito", altaconsulta());
				request.setAttribute("tipo",mensaje);
				request.getRequestDispatcher("/WEB-INF/inicio.jsp").forward(request,response);
			}
		}
			

			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}

			
	}


	public int altaformularioanamnesis(HttpServletRequest request, String oid_cliente)
	{
		Anamnesis anam=new Anamnesis();
		anam.setAqueloatribuye(request.getParameter("atribuye"));
		anam.setQuelepasa(request.getParameter("qls"));
		anam.setDesdecuando(request.getParameter("dc"));
		AnamnesisBLL anambll=new AnamnesisBLL(anam);
		return anambll.altaanamnesisBLL(oid_cliente);
	}
	
	public int obtenerultimaidanamnesis() throws SQLException
	{
		AnamnesisBLL anambll=new AnamnesisBLL();
		return anambll.obtenerultimoid();
	}
	
	public int altanaturaleza(HttpServletRequest request)
	{
		NaturalezaDelDolor natu=new NaturalezaDelDolor();
		natu.setLocalizacion(request.getParameter("localizacion"));
		natu.setCronologia(request.getParameter("cronologia"));
		natu.setIrradiacion(request.getParameter("irradiacion"));
		natu.setForma(request.getParameter("forma"));
		natu.setHora(request.getParameter("hora"));
		natu.setIntensidad(request.getParameter("inten"));
		natu.setFormaComienzo(request.getParameter("comienzo"));
		natu.setRelacionTos(request.getParameter("rbtos"));
		natu.setFactoresDesencadenantes(request.getParameter("desencadenante"));
		natu.setFactoresAliviadores(request.getParameter("aliviadores"));
		natu.setImpotenciaFuncional(request.getParameter("impotencia"));
		natu.setCambiaLugar(request.getParameter("cambialugar"));
		NaturalezaBLL natubll=new NaturalezaBLL(natu);
		
		return natubll.altaNaturalezaBLL(consulta.getOid_anamnesis());
	}
	
	public int obtenerultimaidnaturaleza() throws SQLException
	{
		NaturalezaBLL natubll=new NaturalezaBLL();
		return natubll.obtenerultimoid();
	}
	
	public int altaexploracion(HttpServletRequest request) {
		
		Exploracion ex=new Exploracion();
		ex.setInspeccionVisual(request.getParameter("visual"));
		ex.setPalpación(request.getParameter("palpacion"));
		ex.setTestDeMovilidad(request.getParameter("movilidad"));
		ex.setTestOrtopedico(request.getParameter("ortopedico"));
		
		ExploracionBLL expbll=new ExploracionBLL(ex);
		return expbll.AltaExploracion();
		
	}
	
	public int obtenerultimaidExploracion() throws SQLException
	{
		try {

			ExploracionBLL expbll=new ExploracionBLL();
			return expbll.obtenerultimoid();
			
		} catch (Exception e) {
			// TODO: handle exception
			return 0;
		}
	}
	
	public int altatratamiento (HttpServletRequest Request)
	{
		Tratamiento tra=new Tratamiento();		
		tra.setTratamiento(Request.getParameter("tratamiento"));
		TratamientoBLL traBLL = new TratamientoBLL(tra);
		return traBLL.AltaTratamiento();
	}
	
	public int ObtenerUltimaIdTratamiento() throws SQLException
	{
		TratamientoBLL traBLL=new TratamientoBLL();
		return traBLL.obtenerultimoid();
	}
	
	public int altaconsulta()
	{
		ConsultaBLL conbll=new ConsultaBLL(consulta);
		 
		return conbll.AltaConsulta();
	}
}
