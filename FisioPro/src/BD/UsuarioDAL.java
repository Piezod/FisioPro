package BD;

//import com.mysql.jdbc.*;

import Entidades.Usuario;

import java.sql.*;

public class UsuarioDAL {

	private Conexion bd;
	
	public UsuarioDAL() {
		// TODO Auto-generated constructor stub
		bd=new Conexion();
	}
	
	
	public void crearusuario(Usuario usuario,String pass) throws SQLException
	{
		
		bd=new Conexion();
		
		try {
			/*
			 * Crear un metodo para validar si existe o no el usuario repetido
			 * ya que la id del usuario (oid_usuario) es unico
			 */
			bd.getConexion().setAutoCommit(false);
			String query = "insert into vipr_tusuario values (?,?,?,?)";
			PreparedStatement psInsertar = bd.getConexion().prepareStatement(query);
			psInsertar.setString(0,usuario.getId());
			psInsertar.setInt(1, pass.hashCode());
			psInsertar.setString(2, usuario.getNombre());
			psInsertar.setString(3, usuario.getEmail());
			psInsertar.executeQuery();
			
		} catch (SQLException e) {
			// TODO: handle exception
			
			if (bd!=null)
			{
				 try {
		                System.err.print("Transaction is being rolled back");
		                bd.getConexion().rollback();
		            } catch(SQLException excep) {
		                System.err.println(excep);
		            }
			}
			
		}
		finally {
			
			bd.getConexion().setAutoCommit(true);
		}
		

		bd.cerrarConexion();
		
		
	}
	
	public void rellenarusuario(String oid_usuario,Usuario usuario) throws SQLException
	{
		
		boolean enc=false;
		String query="select * from vipr_tusuario where oid_usuario like ?";
				
		try {
			PreparedStatement psResulset = bd.getConexion().prepareStatement(query);
			psResulset.setString(1, oid_usuario);
			ResultSet rs=psResulset.executeQuery();

			if (rs.next())
			{
					usuario.setId(rs.getString(1));
					usuario.setNombre(rs.getString(3));
					usuario.setEmail(rs.getString(4));
			}
			
			bd.cerrarConexion();
						
		} catch (SQLException e) {
			// TODO: handle exception
			bd.cerrarConexion();
			System.err.println("error en buscar usuariodal.rellenarusuario");
			
		}
	}
	
	
}
