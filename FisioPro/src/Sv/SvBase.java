package Sv;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import error.GenericException;


public abstract class SvBase extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	public abstract void doProcess(HttpServletRequest request, HttpServletResponse response) throws GenericException, ServletException, IOException;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			doProcess(request,response);
		}catch(GenericException e) {
			e.printStackTrace();
			/*
			 * e.getdescripcion me dice que error me ha dado
			 */
			request.setAttribute("descripcion", e.getDescripcion());
			/*
			 * Si casca por una genericexception lo envio a una jsp
			 */
			request.getRequestDispatcher("WEB-INF/error.jsp").forward(request,response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
