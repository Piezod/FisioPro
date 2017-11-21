package BD;

import java.beans.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Entidades.AntecedentesPersonales;
import Entidades.Cliente;

public class AntecedentesPersonalesDAL {

	private Conexion c;
	private AntecedentesPersonales ap;
	
	/**
	 * Constructor para ejecutar cosas relativas al formulario antecedentes personales (ap)
	 * @param ap objeto con los datos del formulario antecedentespersonales
	 */
	public AntecedentesPersonalesDAL(AntecedentesPersonales ap)
	{
		this.ap=ap;
	}
	
	
	/**
	 * DA DE ALTA UN ATNECEDENTE PERSONAL. 
	 * LA ID DEL ATECEDENTE PERSONAL Y LA ID DEL CLIENTE SON LA MISMA.
	 * 
	 * @return Devolvera 1 si se ha realizado el alta satisfactoriamente o un 0 si no se ha realizado
	 */
	public int AltaAntecedente()
	{
		int insercion = 0;
		c=new Conexion();
		
		//INSERT INTO `vipr_tantecedentes_personales`
		//(`oid_antecedentes_personales`, `oid_cliente`, `des_eg`, `des_oq`, `des_tma`, `des_la`)
		//VALUES ([value-1],[value-2],[value-3],[value-4],[value-5],[value-6])
		
		String query="insert into vipr_tantecedentes_personales values (?,?,?,?,?,?)";
		
		try {
			PreparedStatement psResulset = c.getConexion().prepareStatement(query);
			psResulset.setInt(1,ap.getOid_cliente()); // Este campo y el oid cliente son el mismo, cualquiera es la clave primaria
			psResulset.setInt(2, ap.getOid_cliente());
			psResulset.setString(3, ap.getEnfermedadesGraves());
			psResulset.setString(4, ap.getOperacionesQuirurjicas());
			psResulset.setString(5, ap.getTratamientoMedicoActual());
			psResulset.setString(6, ap.getLesionesAntiguas());
			insercion=psResulset.executeUpdate();
						 
		} catch (SQLException e) {
			// TODO: handle exception
			
			System.err.println("error en buscar AntecedentesPersonales" + e);
		}
		finally {
			c.cerrarConexion();
		}
		return insercion;
	}
	
	
	
	/**
	 * NOS DEVUELVE EL ULTIMO ID DE ANTECEDENTES PERSONALES
	 * @return nos devuelve la ultima id del cliente al darlo de alta
	 * @throws SQLException
	 */
	public int obtenerultimoid() throws SQLException
	{
		c=new Conexion();
		int enc=0;
		String query="select oid_antecedentes_personales from VIPR_TANTECEDENTES_PERSONALES"
				+ " order by oid_cliente DESC limit 1 ";
				
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
			
			System.err.println("error en buscar aNTECEDENTESPERSONALESDAL.obtenerultimoid "+ e );
		}
		finally {
			c.cerrarConexion();
		}
		return enc;
	}

	
	
	
	
	
}