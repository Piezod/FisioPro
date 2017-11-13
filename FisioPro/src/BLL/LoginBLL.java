package BLL;
import java.sql.SQLException;

import BD.*;
import Entidades.*;

public class LoginBLL {

	boolean _login;
	Usuario Euser;
	
	public LoginBLL(Usuario usuario) {
		// TODO Auto-generated constructor stub
		
		Euser=usuario;
	}
	
	
	public boolean comprobarlogin(String usuario, String pass) throws SQLException
	{
			LoginDAL ld=new LoginDAL(usuario, pass);
			if (ld.buscarusuario())
			{
				/*
				 * Si encontramos el usuario, recargamos la entidad usuario con sus datos
				 */
				UsuarioDAL udal=new UsuarioDAL();
				udal.rellenarusuario(usuario, Euser);
				return true;
			}
			else 
				return false;
	}
	
	
}
