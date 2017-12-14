package BD;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import Entidades.*;

public class CitaDAL {

	private Cita cita;
	private Conexion c;

	public CitaDAL(Cita cita) {

		this.cita=new Cita();
		this.cita=cita;
	}
	public CitaDAL()
	{
		
	}
	/**
	 * Metodo para dar de alta una cita
	 * @return Retorna 1 si se ha realizado el insert o un 0 si ha fallado algo
	 */
	public int CrearCita()
	{
		//  1º oid_cita , 2º oid_cliente , 3º oid_horario , 4º fecha, 5º bol_activa
		 
		int insercion = 0;
		c=new Conexion();
		String query="insert into vipr_tcita values (?,?,?,?,?)";
		
		try {
			PreparedStatement psResulset = c.getConexion().prepareStatement(query);
			psResulset.setInt(1,0); // Este campo es autoincremental en la bd
			psResulset.setInt(2,cita.getOid_cliente());
			psResulset.setInt(3, cita.getOid_horario());
			psResulset.setString(4, cita.getFecha());
			psResulset.setInt(5, 1); // Se le pone por defecto valor 1, que es que la cita se ha dado de alta.
			insercion=psResulset.executeUpdate();
						 
		} catch (SQLException e) {

			System.err.println("error en buscar CitaDAL.AltaCita al realizar el insert" + e);
		}
		finally {
			c.cerrarConexion();
		}
		return insercion;
	}
	public List<DetalleCita> citasparahoy() {
		
		List<DetalleCita> listacita=new ArrayList<>();
			
		c=new Conexion();
		Date hoy=new Date();
		System.out.print("Ver consultas de la fecha :");
		
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Calendar calen=Calendar.getInstance();
		calen.setTime(hoy);
		String fechahoy=sdf.format(calen.getTime());
		System.out.println(fechahoy);
		calen.add(Calendar.DATE,1);
		String fechamaxima=sdf.format(calen.getTime());
		calen.add(Calendar.DATE,-2);
		String fechaminima=sdf.format(calen.getTime());
		
		String query="select tcliente.des_nombre\r\n" + 
				",tcliente.des_apellido1\r\n" + 
				",tcliente.des_apellido2\r\n" + 
				",vipr_thorario.des_horario\r\n" + 
				",vipr_tcita.oid_cita \r\n"
				+ ", vipr_tcita.oid_cliente"
				+ ",(SELECT COUNT(1) from vipr_tcita where tcliente.oid_cliente = vipr_tcita.oid_cliente\r\n" + 
				"  AND vipr_tcita.fecha < '"+fechaminima+"'\r\n" + 
				"  \r\n" + 
				"  GROUP by vipr_tcita.oid_cliente) as VecesCita " +  
				"from vipr_tcita\r\n" + 
				"INNER JOIN tcliente on tcliente.oid_cliente = vipr_tcita.oid_cita\r\n" + 
				"INNER join vipr_thorario on vipr_thorario.oid_horario= vipr_tcita.oid_horario\r\n" + 
				"where fecha like '"+fechahoy+"'"
				+ "and vipr_tcita.bol_activa = 1";
				
		try {
			
			ResultSet rs=c.getstm().executeQuery(query);
			while (rs.next())
			{
				DetalleCita dc=new DetalleCita();
				dc.setNombre(rs.getString(1));
				dc.setApellido1(rs.getString(2));
				dc.setApellido2(rs.getString(3));
				dc.setDes_horario(rs.getString(4));				
				dc.setOid_cita(rs.getInt(5));
				dc.setOid_cliente(rs.getInt(6));
				dc.setNumerocitas(rs.getInt(7));
				listacita.add(dc);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			
			System.err.println("error en buscar Consultadal.verconsultashoy "+ e.getLocalizedMessage() );
		}
		finally {
			c.cerrarConexion();
		}
		
		return listacita;
		
	}
	/** Metodo que cancela la cita en caso de que se cambie por consulta
	 * @return retorna int 1= se realizo update
	 *  o un 0 = algo fallo o no se realizo
	 */
	public int cancelarcita() {
		int insercion = 0;
		c=new Conexion();
	//  1º oid_cita , 2º oid_cliente , 3º oid_horario , 4º fecha, 5º bol_activa
		String query="update vipr_tcita set "
				+ "bol_activa = ?"
				+ " where oid_cita = ?";
		
		try {
			PreparedStatement psResulset = c.getConexion().prepareStatement(query);
			//valores
			psResulset.setString(1, "0");
			//where
			psResulset.setInt(2, cita.getOid_cita());
			insercion=psResulset.executeUpdate();
						 
		} catch (SQLException e) {
			// TODO: handle exception
			
			System.err.println("error en buscar CitaDAL.cancelarcita" + e);
		}
		finally {
			c.cerrarConexion();
		}
		return insercion;
	}
}
