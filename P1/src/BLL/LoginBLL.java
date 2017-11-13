package BLL;
import java.sql.SQLException;

import BD.*;


public class LoginBLL {

	boolean _login;
	
	public boolean comprobarlogin(String usuario, String pass) throws SQLException
	{
			LoginDAL ld=new LoginDAL(usuario, pass);
			return ld.buscarusuario();
	}
	
	
}
