package Sv;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import BLL.ConsultaBLL;
import Entidades.Consulta;

/**
 * Servlet implementation class PruebaAjax
 */
@WebServlet("/PruebaAjax")
public class PruebaAjax extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PruebaAjax() {
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
		/*
		 * Ejemplo para enviar informacion plana en tipo texto al jsp
		 
	    response.setContentType("text/plain");  // Set content type of the response so that jQuery knows what it can expect.
	    response.setCharacterEncoding("UTF-8"); // You want world domination, huh?
	    response.getWriter().write("respuesta de ajax");       // Write response body.
		*/
		
		/*
		 * ejemplo para enviar una lista de texto plana a ajax en la jsp mediante Json
		 List<String> list = new ArrayList<String>();
		    list.add("item1");
		    list.add("item2");
		    list.add("item3");
		    String json = new Gson().toJson(list);

		    response.setContentType("application/json");
		    response.setCharacterEncoding("UTF-8");
		    response.getWriter().write(json);
		    */
		
		   String json = new Gson().toJson(consultashoy());

		    response.setContentType("application/json");
		    response.setCharacterEncoding("UTF-8");
		    response.getWriter().write(json);
		
	}
	
	public List<Consulta> consultashoy()
	{
		ConsultaBLL consulbll=new ConsultaBLL();
		return consulbll.verconsultashoy();
	}
	
	

}
