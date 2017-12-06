package BD;

import java.beans.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import Entidades.*;
public class ConsultaDAL {

		private Consulta consul;
		private Conexion c;
		
/*
 *  Tabla vipr_ttratamiento
 */
		
		/**
		 * Constructor para realizar el alta y require el objeto naturaleza con los datos del jsp y el
		 * id del formulario de anamnesis
		 * @param AnamnesisDAL
		 */
		 public ConsultaDAL(Consulta consul) {
			// TODO Auto-generated constructor stub
		this.consul=new Consulta();
		this.consul=consul;
		
		}
		
		public ConsultaDAL()
		{
			
		}

		
		/**
		 * MEtodo para realizar el alta del formulario de Consulta
		 * en el realizaremos el insert de los datos recogidos en la jsp 
		 * 
		 * @return Devolvera 1 si se ha realizado el alta satisfactoriamente o un 0 si no se ha realizado
		 */
		
		public int AltaConsulta()
		{
			// 1º oid_consulta , 2º oid_cliente , 3º oid_anamnesis , 4º oid_exploracion , 5º oid_tratamiento 
			// 6º fecha ,        7º motivo
			 
			int insercion = 0;
			c=new Conexion();
			String query="insert into vipr_tconsulta values (?,?,?,?,?,?,?)";
			GregorianCalendar g=new GregorianCalendar();
			Date d1=new Date();
			System.out.print("Alta de consulta : en la fecha ");
			System.out.println(d1);
			String newdate=new SimpleDateFormat("yyyy-MM-dd").format(d1);
			System.out.println("Fecha con formato "+newdate);
			try {
				PreparedStatement psResulset = c.getConexion().prepareStatement(query);
				psResulset.setInt(1,0); // Este campo es autoincremental en la bd
				psResulset.setInt(2, consul.getOid_cliente());
				psResulset.setInt(3,consul.getOid_anamnesis());
				psResulset.setInt(4,consul.getOid_exploración());
				psResulset.setInt(5,consul.getOid_tratamiento());				
				psResulset.setString(6,newdate); // fecha
				psResulset.setString(7,consul.getMotivo());
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
		public Cliente RellenarAnamnesis (Cliente cli)
		{
			Cliente auxcli=new Cliente();
			c=new Conexion();
			String query="select * from tcliente where oid_cliente = '"+cli.getOid()+"'";
					
			try {
				
				ResultSet rs=c.getstm().executeQuery(query);
				while (rs.next())
				{
					auxcli.setOid(rs.getInt(1));
					auxcli.setNombre(rs.getString(2));
					auxcli.setApellido1(rs.getString(3));
					auxcli.setApellido2(rs.getString(4));
					auxcli.setEdad(rs.getString(5));
					auxcli.setTelefono(rs.getString(6));
				}
				
			} catch (Exception e) {
				// TODO: handle exception
				
				System.err.println("error en buscar Consultadal.RellenarConsulta "+ e.getLocalizedMessage() );
			}
			finally {
				c.cerrarConexion();
			}
			
			return auxcli;
		}

		public List<Consulta> verconsultashoy() {
			// TODO Auto-generated method stub
			
			List<Consulta> consultas=new ArrayList<Consulta>();
			c=new Conexion();
			Date hoy=new Date();
			System.out.print("Ver consultas de la fecha :");
			System.out.println(hoy);
			
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			Calendar calen=Calendar.getInstance();
			calen.setTime(hoy);
			calen.add(Calendar.DATE,1);
			String fechamaxima=sdf.format(calen.getTime());
			calen.add(Calendar.DATE,-2);
			String fechaminima=sdf.format(calen.getTime());
			
			String query="select * from vipr_tconsulta where fecha BETWEEN '"+fechaminima+"' AND '"+fechamaxima+"'";
					
			try {
				
				ResultSet rs=c.getstm().executeQuery(query);
				while (rs.next())
				{
					Consulta consul=new Consulta();
					consul.setOid_consulta(rs.getInt(1));
					consul.setOid_cliente(rs.getInt(2));
					consul.setOid_anamnesis(rs.getInt(3));
					consul.setOid_tratamiento(rs.getInt(4));
					consul.setFecha(rs.getString(5));
					consul.setMotivo(rs.getString(6));
					consultas.add(consul);
				}
				
			} catch (Exception e) {
				// TODO: handle exception
				
				System.err.println("error en buscar Consultadal.verconsultashoy "+ e.getLocalizedMessage() );
			}
			finally {
				c.cerrarConexion();
			}
			
			return consultas;
			
			
			
		}
		
		public List<DetalleConsulta> rellenarconsultaporcliente(Consulta consul) {
			
			List<DetalleConsulta> lista=new ArrayList<>();
			c=new Conexion();
			int enc=0;
			String query="SELECT `oid_consulta`"
					+ ", `oid_cliente`"
					+ ", `oid_anamnesis`"
					+ ", `oid_exploracion`"
					+ ", `oid_tratamiento`"
					+ ", `fecha`"
					+ ", `motivo` "
					+ "FROM `vipr_tconsulta`"
					+ " WHERE oid_cliente = "+consul.getOid_cliente();
					
			try {
				
				ResultSet rs=c.getstm().executeQuery(query);
				
				while (rs.next())
				{
					DetalleConsulta detalleconsulta=new DetalleConsulta();
					detalleconsulta.setOid_consulta(rs.getString(1));
					
					//recargamos los datos del cliente
					ClienteDAL cd=new ClienteDAL();
					detalleconsulta.setDetallecliente(cd.RellenarCliente(rs.getString(2)));
					
					//recargamos los datos de la anamnesis
					AnamnesisDAL anamdal=new AnamnesisDAL();
					detalleconsulta.setDetalleanamnesis(anamdal.RellenarAnamnesis(rs.getString(3)));
					
					//recargamos los datos correspondientes a la exploracion
					ExploracionDAL explodal=new ExploracionDAL();
					detalleconsulta.setDetalleexploración(explodal.RellenarExploracion(rs.getString(4)));
					
					//recargamos los datos del tratamiento
					TratamientoDAL tratadal=new TratamientoDAL();
					detalleconsulta.setDetalletratamiento(tratadal.RellenarTratamiento(rs.getString(5)));
					
					detalleconsulta.setFecha(rs.getString(6));
					detalleconsulta.setMotivo(rs.getString(7));
					lista.add(detalleconsulta);
					
				}
							
			} catch (Exception e) {
				// TODO: handle exception
				
				System.err.println("error en buscar ConsultaDAL.rellenarconsulta"+ e );
			}
			finally {
				c.cerrarConexion();
			}
			return lista;
			
		}
		
		public List<PreVerDetalleConsulta> preverdetalleconsultas()
		{
			List<PreVerDetalleConsulta> lista=new ArrayList<>();
			c=new Conexion();
			
					String query="select vipr_tconsulta.oid_consulta\r\n" + 
							",tcliente.des_nombre\r\n" + 
							
							",vipr_tanamnesis.quelepasa\r\n" + 
							",vipr_ttratamiento.des_tratamiento\r\n" + 
							",vipr_tconsulta.fecha\r\n" + 
							",tcliente.des_apellido1\r\n" +
							",vipr_tconsulta.oid_anamnesis\r\n" + 
							",vipr_tconsulta.oid_exploracion\r\n" + 
							",vipr_tconsulta.oid_tratamiento\r\n" + 
							"from vipr_tconsulta\r\n" + 
							"inner join tcliente on  vipr_tconsulta.oid_cliente=tcliente.oid_cliente\r\n" + 
							"inner join vipr_tanamnesis on vipr_tconsulta.oid_anamnesis=vipr_tanamnesis.oid_anamnesis\r\n" + 
							"inner join vipr_texploracion on  vipr_tconsulta.oid_exploracion=vipr_texploracion.oid_exploracion\r\n" + 
							"inner join vipr_ttratamiento on vipr_tconsulta.oid_tratamiento=vipr_ttratamiento.oid_tratamiento\r\n" + 
							"where vipr_tconsulta.oid_cliente = "+consul.getOid_cliente();
			try {
				
				ResultSet rs=c.getstm().executeQuery(query);
				
				while (rs.next())
				{
					PreVerDetalleConsulta consul=new PreVerDetalleConsulta();
					consul.setOid_consulta(rs.getInt(1));
					consul.setNombrecliente(rs.getString(2));
					consul.setQuelepasa(rs.getString(3));
					consul.setTratamiento(rs.getString(4));
					consul.setFecha(rs.getString(5));
					consul.setApellido1(rs.getString(6));
					consul.setOid_anamnesis(rs.getInt(7));
					consul.setOid_exploración(rs.getInt(8));
					consul.setOid_tratamiento(rs.getInt(9));
					lista.add(consul);					
				}
							
			} catch (Exception e) {
				// TODO: handle exception
				
				System.err.println("error en buscar ConsultaDAL.preverdetalleconsultas"+ e );
			}
			finally {
				c.cerrarConexion();
			}
			return lista;
		}
		
}

