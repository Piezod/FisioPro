package BD;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import Entidades.*;

public class CitaDAL {

	private Cita cita;
	private Conexion c;

	public CitaDAL(Cita cita) {

		this.cita=new Cita();
		this.cita=cita;
	}
	
	/**
	 * Metodo para dar de alta una cita
	 * @return Retorna 1 si se ha realizado el insert o un 0 si ha fallado algo
	 */
	public int CrearCita()
	{
		//  1º oid_cita , 2º oid_cliente , 3º oid_horario , 4º fecha
		 
		int insercion = 0;
		c=new Conexion();
		String query="insert into vipr_tcita values (?,?,?,?)";
		
		try {
			PreparedStatement psResulset = c.getConexion().prepareStatement(query);
			psResulset.setInt(1,0); // Este campo es autoincremental en la bd
			psResulset.setInt(2,cita.getOid_cliente());
			psResulset.setInt(3, cita.getOid_horario());
			psResulset.setString(4, cita.getFecha());
			insercion=psResulset.executeUpdate();
						 
		} catch (SQLException e) {

			System.err.println("error en buscar CitaDAL.AltaCita al realizar el insert" + e);
		}
		finally {
			c.cerrarConexion();
		}
		return insercion;
	}
}
