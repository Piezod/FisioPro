package Sv;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BD.AntecedentesPersonalesDAL;
import BLL.AntecedentesPersonalesBLL;
import BLL.ClienteBLL;
import Entidades.AntecedentesPersonales;
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
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String OPERACION = request.getParameter("oper");
		try {
			if (OPERACION.equalsIgnoreCase("alta"))
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
					
					AntecedentesPersonalesBLL ap=new AntecedentesPersonalesBLL(""+idcliente,"","","","");
					crearantecedente(ap);
					request.setAttribute("idcliente",idcliente);
					request.getRequestDispatcher("WEB-INF/AltaCliente/AntecedentesPersonales.jsp").forward(request,response);
				}
				else
				{
					request.getRequestDispatcher("WEB-INF/error.jsp").forward(request,response);
					//throw new Exception("excepcion mia, no se dio de alta el cliente");
					
				}
				
			}
			else if (OPERACION.equalsIgnoreCase("baja"))
			{
				Cliente cli=new Cliente();
				cli.setOid(Integer.parseInt(request.getParameter("cliente")));
				
				System.out.println("Voy a alta baja cliente.jsp"+cli.toString());
				request.setAttribute("exito",1);
				request.setAttribute("tipo",eliminarcliente(cli));
				request.getRequestDispatcher("/WEB-INF/inicio.jsp").forward(request,response);				
			}
			else if (request.getParameter("oper").equalsIgnoreCase("antecedentespersonales"))
			{
				System.out.println("Antecedentes personales id cliente "+ request.getParameter("oid_cliente"));
				AntecedentesPersonales ap=new AntecedentesPersonales();
				

				ap.setOid_cliente(Integer.parseInt(request.getParameter("oid_cliente")));
				ap.setEnfermedadesGraves(request.getParameter("eg"));
				ap.setOperacionesQuirurjicas(request.getParameter("oq"));
				ap.setTratamientoMedicoActual(request.getParameter("tma"));
				ap.setLesionesAntiguas(request.getParameter("la"));					
				int id=actualizarantecedentes(ap);
				if (id>0)
				{
					request.setAttribute("exito",1);
					String mensaje="<div class=\"alert alert-info\">Se dio de Alta <strong>Satisfactoriamente </strong> el cliente</div>";
					request.setAttribute("tipo",mensaje);
					//response.sendRedirect("inicio.jsp");
					request.getRequestDispatcher("/WEB-INF/inicio.jsp").forward(request,response);
				}
				else
				{
					throw new Exception("excepcion mia, no se dio de alta los antecedentes");
				}
			}else if (OPERACION.equalsIgnoreCase("buscarcliente"))
			{
				request.getRequestDispatcher("/WEB-INF/Cliente/ConsultaCliente.jsp").forward(request,response);
			}
			else if (OPERACION.equalsIgnoreCase("modificarcliente"))
			{
				//Relleno objeto cliente
				Cliente cli=new Cliente();
				cli.setOid(Integer.parseInt(request.getParameter("oid_cliente")));
				cli.setNombre(request.getParameter("nombre"));
				cli.setApellido1(request.getParameter("apellido1"));
				cli.setApellido2(request.getParameter("apellido2"));
				cli.setEdad(request.getParameter("edad"));
				cli.setTelefono(request.getParameter("telefono"));
				//Relleno objeto ap
				AntecedentesPersonales ap=new AntecedentesPersonales();
				ap.setOid_cliente(Integer.parseInt(request.getParameter("oid_cliente")));
				ap.setEnfermedadesGraves(request.getParameter("eg"));
				ap.setLesionesAntiguas(request.getParameter("la"));
				ap.setOperacionesQuirurjicas(request.getParameter("oq"));
				ap.setTratamientoMedicoActual(request.getParameter("tm"));
				
				response.getWriter().print("cliente : "+actualizarcliente(cli,ap));;
						
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

	private int actualizarcliente(Cliente cli,AntecedentesPersonales ap)
	{
		ClienteBLL clibll=new ClienteBLL(cli);
		return clibll.actualizarcliente(ap);
	}
	private int actualizarantecedentes(AntecedentesPersonales ap)
	{
		AntecedentesPersonalesBLL apbll=new AntecedentesPersonalesBLL(ap);
		
		return apbll.actualizarap();
	}
	
	/**
	 * Metodo para realizar la eliminación del cliente y sus antecedentes personales.
	 * @param cli objeto tipo cliente con el oid_cliente que se ha de eliminar
	 * @return String con la informacion de registros dados de baja
	 */
	private String eliminarcliente(Cliente cli)
	{
		ClienteBLL clibll=new ClienteBLL(cli);
		return clibll.eliminarcliente();
	}
}
