package Sv;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import error.GenericException;

@WebServlet("/ERROR")
public class SvHerencia extends SvBase{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void doProcess(HttpServletRequest request, HttpServletResponse response) throws GenericException {
				throw new GenericException("ERROR CONTROLADO");
	}

}
