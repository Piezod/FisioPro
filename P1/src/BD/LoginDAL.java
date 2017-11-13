package BD;

import java.sql.*;

public class LoginDAL {

	private String usuario,pass;
	private Conexion c;
	
	public LoginDAL(String usuario, String pass) {
		// TODO Auto-generated constructor stub
		this.usuario=usuario;
		this.pass=pass;
		c=new Conexion();
	}
	
	@SuppressWarnings("finally")
	public boolean buscarusuario() throws SQLException
	{
		
		boolean enc=false;
		String query="select * from vipr_tusuario where oid_usuario like ? and cod_password like ?";
				
		try {
			PreparedStatement psResulset = c.getConexion().prepareStatement(query);
			psResulset.setString(1, usuario.toString());
			psResulset.setString(2, pass.toString());
			ResultSet rs=psResulset.executeQuery();

			if (rs.next())
			{
				enc=true;
			}
			
			c.cerrarConexion();
						
		} catch (SQLException e) {
			// TODO: handle exception
			c.cerrarConexion();
			System.err.println("error en buscar logindal.buscarusuario");
		}
		return enc;
	}
	
	
	
}
