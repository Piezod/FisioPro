package BD;

import java.beans.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Entidades.*;
public class ExploracionDAL {

		private Exploracion exp;
		private Conexion c;
		
/*
 *  Tabla vipr_ttratamiento
 */
		
		/**
		 * Constructor para realizar el alta y require el objeto naturaleza con los datos del jsp y el
		 * id del formulario de anamnesis
		 * @param AnamnesisDAL
		 */
		 public ExploracionDAL(Exploracion tra) {
			// TODO Auto-generated constructor stub
		this.exp=new Exploracion();
		this.exp=tra;
		
		}
		
		public ExploracionDAL()
		{
			
		}

		
		/**
		 * MEtodo para realizar el alta del formulario de Exploracion
		 * en el realizaremos el insert de los datos recogidos en la jsp 
		 * 
		 * @return Devolvera 1 si se ha realizado el alta satisfactoriamente o un 0 si no se ha realizado
		 */
		
		public int AltaExploracion()
		{
			//  1º oid_tratamiento, 2º visual, 3º palpacion, 4º movilidad , 5º ortopedico
			 
			int insercion = 0;
			c=new Conexion();
			String query="insert into vipr_texploracion values (?,?,?,?,?)";
			
			try {
				PreparedStatement psResulset = c.getConexion().prepareStatement(query);
				psResulset.setInt(1,0); // Este campo es autoincremental en la bd
				psResulset.setString(2,exp.getInspeccionVisual());
				psResulset.setString(3, exp.getPalpación());
				psResulset.setString(4, exp.getTestDeMovilidad());
				psResulset.setString(5, exp.getTestOrtopedico());
				insercion=psResulset.executeUpdate();
							 
			} catch (SQLException e) {
				// TODO: handle exception
				
				System.err.println("error en buscar ExploracionDAL.AltaExploracion al realizar el insert" + e);
			}
			finally {
				c.cerrarConexion();
			}
			return insercion;
		}
		
		/**
		 * Metodo para recoger el ultimo id introducido. Este metodo se llama despues de dar de alta.
		 * @return nos devuelve la ultima id del cliente al darlo de alta
		 * @throws SQLException
		 */
		public int obtenerultimoid() throws SQLException
		{
			c=new Conexion();
			int enc=0;
			String query="select oid_exploracion from vipr_texploracion order by oid_exploracion DESC limit 1 ";
					
			try {
				
				ResultSet rs=c.getstm().executeQuery(query);

				if (rs.next())
				{
					enc=(rs.getInt(1));
					
				}
				else
				{

					System.out.println(enc);
				}
							
			} catch (Exception e) {
				// TODO: handle exception
				
				System.err.println("error en buscar ExploracionDAL.Obtenerultimoid "+ e );
			}
			finally {
				c.cerrarConexion();
			}
			return enc;
		}
		
		/** Metodo que devolvera el anamnesis de una consulta en concreto
		 * 
		 * @return Devolvera un objeto anamnesis con los datos de la consulta especifica.
		 */
		public  Exploracion RellenarExploracion (String oid_explo)
		{
			
			c=new Conexion();
			String query="SELECT `oid_exploracion`"
					+ ", `visual`"
					+ ", `palpacion`"
					+ ", `movilidad`"
					+ ", `ortopedico`"
					+ " FROM `vipr_texploracion` "
					+ "WHERE oid_exploracion like '"+oid_explo+"'";
			Exploracion explo=new Exploracion();
			try {
				
				ResultSet rs=c.getstm().executeQuery(query);
				while (rs.next())
				{
					explo.setInspeccionVisual(rs.getString(2));
					explo.setPalpación(rs.getString(3));
					explo.setTestDeMovilidad(rs.getString(4));
					explo.setTestOrtopedico(rs.getString(5));
				}
				
			} catch (Exception e) {
				// TODO: handle exception
				
				System.err.println("error en buscar ExploracionDAL.RellenarExploracion"+ e.getLocalizedMessage() );
			}
			finally {
				c.cerrarConexion();
			}
			
			return explo;
		}
		
	}

