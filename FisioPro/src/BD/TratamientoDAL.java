package BD;
import java.beans.Statement;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import Entidades.*;
public class TratamientoDAL {

		private Tratamiento tra;
		private Conexion c;
		
/*
 *  Tabla vipr_ttratamiento
 *  1º oid_tratamiento
 *  2º tratamiento
 */
		
		/**
		 * Constructor para realizar el alta y require el objeto naturaleza con los datos del jsp y el
		 * id del formulario de anamnesis
		 * @param AnamnesisDAL
		 */
		 public TratamientoDAL(Tratamiento tra) {
			// TODO Auto-generated constructor stub
		this.tra=new Tratamiento();
		this.tra=tra;
		
		}
		
		public TratamientoDAL()
		{
			
		}

		
		/**
		 * MEtodo para realizar el alta del formulario de Tratamiento
		 * en el realizaremos el insert de los datos recogidos en la jsp 
		 * 
		 * @return Devolvera 1 si se ha realizado el alta satisfactoriamente o un 0 si no se ha realizado
		 */
		
		public int AltaExploracion()
		{
			//  1º oid_tratamiento, 2º visual, 3º palpacion, 4º movilidad , 5º ortopedico
			 
			int insercion = 0;
			c=new Conexion();
			String query="insert into vipr_ttratamiento values (?,?)";
			tra.setTratamiento(tra.getTratamiento().replaceAll("\n","<br />")); 
			try {
				PreparedStatement psResulset = c.getConexion().prepareStatement(query);
				psResulset.setInt(1,0); // Este campo es autoincremental en la bd
				psResulset.setString(2,tra.getTratamiento());
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
			String query="select oid_tratamiento from vipr_ttratamiento order by oid_tratamiento DESC limit 1 ";
					
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
		
		/** Metodo que devolvera el tratamiento de una consulta en concreto
		 * 
		 * @return Devolvera un objeto anamnesis con los datos de la consulta especifica.
		 */
		public Tratamiento RellenarTratamiento (String oid_tra)
		{
			Tratamiento auxtra=new Tratamiento();
			auxtra.setOid_tratamiento(Integer.parseInt(oid_tra));
			c=new Conexion();
			String query="select * from vipr_ttratamiento where oid_Tratamiento = '"+auxtra.getOid_tratamiento()+"'";
					
			try {
				
				ResultSet rs=c.getstm().executeQuery(query);
				while (rs.next())
				{
					auxtra.setOid_tratamiento(rs.getInt(1));
					auxtra.setTratamiento(rs.getString(2));
				}
				
			} catch (Exception e) {
				// TODO: handle exception
				
				System.err.println("error en buscar TratamientoDAL.RellenarTratamiento "+ e.getLocalizedMessage() );
			}
			finally {
				c.cerrarConexion();
			}
			
			return auxtra;
		}
		
	}


