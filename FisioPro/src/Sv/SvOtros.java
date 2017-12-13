package Sv;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import error.GenericException;

/**
 * Servlet implementation class SvOtros
 */
@WebServlet("/SvOtros")
public class SvOtros extends SvBase {
	private static final long serialVersionUID = 1L;
	private static String OPERACION;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SvOtros() {
        super();
        // TODO Auto-generated constructor stub
    }

	@Override
	public void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws GenericException, ServletException, IOException {
		try {
			OPERACION=request.getParameter("oper");
			
			if (OPERACION.equalsIgnoreCase("contact"))
			{
				System.out.println("Vamos a ver la información de la consulta");
				request.setAttribute("datos", "infoempresa");
				request.getRequestDispatcher("WEB-INF/InfoEmpresa/InfoEmpresa.jsp").forward(request,response);

			}
			else
			{
				request.getRequestDispatcher("WEB-INF/inicio.jsp").forward(request,response);
			}
		} catch (Exception e) {
			request.getRequestDispatcher("WEB-INF/error.jsp").forward(request,response);
		}
	
	}



}
