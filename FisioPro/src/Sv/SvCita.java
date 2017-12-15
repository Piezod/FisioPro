package Sv;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonElement;

import BLL.CitaBLL;
import BLL.ClienteBLL;
import BLL.HorariosBLL;
import Entidades.*;
import error.GenericException;

/**
 * Servlet implementation class SvCita
 */
@WebServlet("/SvCita")
public class SvCita extends SvBase {
	private static final long serialVersionUID = 1L;
    private static String OPERACION;  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SvCita() {
        super();
        // TODO Auto-generated constructor stub
    }

	@Override
	public void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws GenericException, ServletException, IOException {		
					try {
						OPERACION=request.getParameter("oper");
						if (OPERACION.equalsIgnoreCase("alta"))
						{
							request.setAttribute("fechahoy", fechahoy());	
							System.out.println(fechahoy());
							request.getRequestDispatcher("WEB-INF/GestionCitas/AltaCitas.jsp").forward(request,response);
						}else if (OPERACION.equalsIgnoreCase("cancelacion"))
						{
							
						}else if (OPERACION.equalsIgnoreCase("verhorariodisponibles"))
						{
							System.out.println("Devuelvo los horarios disponibles");

							 String json = new Gson().toJson(horariosdisponibles(request.getParameter("fecha")));
							    response.setContentType("application/json");
							    response.setCharacterEncoding("UTF-8");
							    System.out.println("Devolviendo el objeto a json horarios "+json);
							    response.getWriter().write(json);
						}else if (OPERACION.equalsIgnoreCase("buscarcliente"))
						{
							System.out.println("Devuelvo los clientes");

							 String json = new Gson().toJson(listaclientes(request.getParameter("nombre")));
							 System.out.println("Devuelvo json de clientes "+json);
							    response.setContentType("application/json");
							    response.setCharacterEncoding("UTF-8");
							    response.getWriter().write(json);
						}else if (OPERACION.equalsIgnoreCase("crearcita"))
						{
							Cita cita=new Cita();
							cita.setFecha(request.getParameter("fecha"));
							cita.setOid_horario(Integer.parseInt(request.getParameter("horario")));
							cita.setOid_cliente(Integer.parseInt(request.getParameter("oid_cliente")));
							System.out.println(cita.toString());
							response.getWriter().print(CrearCita(cita));
						}else if (OPERACION.equalsIgnoreCase("citashoy"))
						{
							String json = new Gson().toJson(citasparahoy());							
						    response.setContentType("application/json");
						    response.setCharacterEncoding("UTF-8");
						    response.getWriter().print(json);
						}else if (OPERACION.equalsIgnoreCase("cancelarcita"))
						{
							Cita cita=new Cita();
							cita.setOid_cita(Integer.parseInt(request.getParameter("oid_cita")));						
						    response.getWriter().print(cancelarcita(cita));
						}else if(OPERACION.equalsIgnoreCase("cancecita"))
						{							
							System.out.println("pagina cancelar cita");
							request.setAttribute("fechahoy", fechahoy());	
							System.out.println(fechahoy());
							//Le paso esta fecha para que si o si, el calendario me deje seleccionar fechas de hoy en futuro
							request.getRequestDispatcher("WEB-INF/GestionCitas/CancelarCita.jsp").forward(request,response);
						}else if (OPERACION.equalsIgnoreCase("VerCitasFecha"))
						{
							
							
							 String json = new Gson().toJson(listacitasfecha(request.getParameter("fecha")));
							 System.out.println("Devuelvo json de citas segun fecha "+json);
							    response.setContentType("application/json");
							    response.setCharacterEncoding("UTF-8");
							    response.getWriter().write(json);
						}						
						else
						{
							System.out.println("no existe ese jsp");
							request.getRequestDispatcher("inicio.jsp").forward(request,response);
						}
						
					} catch (Exception e) {
						request.getRequestDispatcher("WEB-INF/error.jsp").forward(request,response);
					}
		
	}
	
	private List<DetalleCita> listacitasfecha(String fecha) {

		CitaBLL citabll=new CitaBLL();
		return citabll.listacitasfecha(fecha);
	}

	public List<Horarios> horariosdisponibles(String fecha) throws SQLException
	{
		HorariosBLL hbll=new HorariosBLL();
		return hbll.horariosdisponibles(fecha);
	}
	
	public List<Cliente> listaclientes(String nombre)
	{
		Cliente cli=new Cliente();
		cli.setNombre(nombre);
		ClienteBLL clibll=new ClienteBLL(cli);
		return clibll.buscarclientes();
	}
	
	
	/** Metodo para ponerle la fecha de hoy al datepicker
	 * @return
	 */
	public String fechahoy()
	{
		GregorianCalendar g=new GregorianCalendar();
		String dia=""+g.get(Calendar.DAY_OF_MONTH);
		int mes=(g.get(Calendar.MONTH)+1);
		String year=""+g.get(Calendar.YEAR);
		return year+"-"+mes+"-"+dia;
	}

	/**
	 * Metodo para dar de alta la cita, 
	 * @param cita Objeto tipo cita, relleno con los datos recogidos de la pagina
	 * @return Devolvera 1 si se ha producido el alta, o un 0 si no se ha realizado el insert
	 */
	public int CrearCita(Cita cita)
	{
		CitaBLL citabll=new CitaBLL(cita);
		citabll.CrearCita();
		return 1;
	}
	
	/** Metodo para ver las citas de hoy
	 * @return lista tipo detallecita con las citas del dia de hoy
	 */
	public List<DetalleCita> citasparahoy()
	{
		
		CitaBLL citabll=new CitaBLL();
		return citabll.citasparahoy();
	}

	/** Metodo que hace la cancelacion de la cita
	 * @param cita objeto cita que con el id que hay que cancelar
	 * @return devolvera un 1 si se ha cancelado la cita o 0 si se ha producido algun error
	 */
	public int cancelarcita(Cita cita)
	{
		CitaBLL citabll=new CitaBLL(cita);
		return citabll.cancelarcita();
	}
}
