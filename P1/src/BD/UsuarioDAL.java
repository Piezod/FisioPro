package BD;

import com.mysql.jdbc.*;

import Entidades.Usuario;

import java.sql.*;
import java.sql.PreparedStatement;

public class UsuarioDAL {

	private Conexion bd;
	
	
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
	
	
}
