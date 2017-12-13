package Sv;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BLL.AntecedentesPersonalesBLL;
import BLL.ClienteBLL;
import Entidades.AntecedentesPersonales;
import Entidades.Cliente;

/**
 * Servlet implementation class SvConsultaCliente
 */
@WebServlet("/SvConsultaCliente")
public class SvConsultaCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Integer NumeroMaximoRegistros=0;
	private static Integer NumeroPaginaciones=0;
	private static String NumeroPulsado="0";
	private static List<Cliente> list=new ArrayList<>();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SvConsultaCliente() {
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
		// TODO Auto-generated method stub
		
		try {
			if (request.getParameter("oper").equalsIgnoreCase("consulta"))
			{
				Cliente cli=new Cliente();
				cli.setNombre(request.getParameter("name"));
				NumeroPulsado=request.getParameter("NumeroPulsado");
				
				request.setAttribute("listacliente",buscarclientes(cli));
				request.setAttribute("mostrarconsulta", true);
				request.setAttribute("NumeroMaximoRegistros",NumeroMaximoRegistros);
				request.setAttribute("NumeroPaginaciones",NumeroPaginaciones);
				request.setAttribute("name", cli.getNombre());
				
				request.getRequestDispatcher("WEB-INF/Consulta/ListaConsultaCliente.jsp").forward(request,response);
			}
			else if (request.getParameter("oper").equalsIgnoreCase("perfil"))
			{
				Cliente cli=new Cliente();
				cli.setOid(Integer.parseInt(request.getParameter("oid")));
				request.setAttribute("cliente", buscarcliente(cli));
				request.setAttribute("antecedentes", buscarantecedentes(cli));
				request.getRequestDispatcher("WEB-INF/Cliente/PerfilCliente.jsp").forward(request,response);

			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("Error en SvConsultaDal " +e);
		}
	}
	
	/**
	 * Metodo que retorna una lista de clientes encontrados segun el 
	 * nombre que se ha recogido del formulario anterior
	 * @param Objeto tipo cliente que contiene el nombre recogido en el formulario
	 * @return List<Cliente> que puede o no contener. En caso de que no tenga nada
	 * cargara un cliente ficticio con los datos de "No se encontro nada"
	 */
	private List<Cliente> buscarclientes(Cliente cli)
	{
		
		ClienteBLL clibl=new ClienteBLL(cli);
		
				list=clibl.buscarclientes();
				/*
				 * Saco el numero de registros encontrados
				 */
				NumeroMaximoRegistros=list.size();
				/*
				 * Lo divido entre 10 porque mostrare de 10 en 10 las consultas
				 */
				if (NumeroMaximoRegistros%10>0)
				{
					NumeroPaginaciones=(NumeroMaximoRegistros/10);
				}else
				{
					NumeroPaginaciones=(NumeroMaximoRegistros/10)-1;
				}
				
				
				/*
				 * Recojo el numero pulsado, si no hay boton, es porque nos ehace recarga desde la consulta
				 * y no se debera de mostrar mas que los 10 primeros
				 */
				if (NumeroPulsado==null)
				{
					NumeroPulsado="0";
				}
				
				/*
				 * En la bll recorto la lista total, en funcion del boton que he pulsado para ver la lista
				 * es de cir, si pulsa el boton 2, la bll me hara la logica para recortarmelo en funcion de ese parametro
				 */
				return clibl.recortarlista(Integer.parseInt(NumeroPulsado),NumeroPaginaciones);
	}

	/**
	 * Metodo para recargar la información de un unico cliente
	 * @param cli
	 * @return el objeto cliente rellenado con la información
	 */
	private Cliente buscarcliente(Cliente cli)
	{
		ClienteBLL clibll=new ClienteBLL();
		return clibll.RellenarCliente(cli);
	}
	
	private AntecedentesPersonales buscarantecedentes(Cliente cli)
	{
		AntecedentesPersonalesBLL apbll=new AntecedentesPersonalesBLL();
		AntecedentesPersonales ap=new AntecedentesPersonales();
		ap=apbll.RellenarAntecedentes(cli);
		return ap;
		
	}
	
}
