package BD;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Entidades.Cliente;

public class ClienteDAL {

	private Cliente cli;
	private Conexion c;
	
	
	
	public ClienteDAL(Cliente cli) {
		
		this.cli=cli;
		c=new Conexion();
		// TODO Auto-generated constructor stub
	}
	
	
	/**
	 * Metodo que nos conectara a la base de dato y realizara un insert en la tabla vipr_tcliente. 
	 * 
	 * @return Devolvera 1 si se ha realizado el alta satisfactoriamente o un 0 si no se ha realizado
	 */
	public int AltaCliente()
	{
		int insercion = 0;
		
		String query="insert into tcliente values (?,?,?,?,?,?)";
		
		try {
			PreparedStatement psResulset = c.getConexion().prepareStatement(query);
			psResulset.setInt(1,0); // Este campo es autoincremental en la bd
			psResulset.setString(2, cli.getNombre());
			psResulset.setString(3, cli.getApellido1());
			psResulset.setString(4, cli.getApellido2());
			psResulset.setInt(5, cli.getEdad());
			psResulset.setInt(6, cli.getTelefono());
			insercion=psResulset.executeUpdate();
						 
		} catch (SQLException e) {
			// TODO: handle exception
			
			System.err.println("error en buscar logindal.buscarusuario" + e);
		}
		finally {
			c.cerrarConexion();
		}
		return insercion;
	}
	
	
	/*
	public boolean buscarcliente() throws SQLException
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
			
						
		} catch (SQLException e) {
			// TODO: handle exception
			
			System.err.println("error en buscar logindal.buscarusuario");
		}
		finally {
			c.cerrarConexion();
		}
		return enc;
	}
	
	*/
	
	
	
	
	
}