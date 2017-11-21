package BD;

import java.beans.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Entidades.AntecedentesPersonales;
import Entidades.Cliente;

public class ClienteDAL {

	private Cliente cli;
	private Conexion c;
	private AntecedentesPersonales ap;
	
	
	
	/**
	 * Constructor para ejecutar cosas relativas al cliente propiamente dicho
	 * @param cli
	 */
	public ClienteDAL(Cliente cli) {
		
		this.cli=cli;
		
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Constructor para ejecutar cosas relativas al formulario antecedentes personales (ap)
	 * @param ap objeto con los datos del formulario antecedentespersonales
	 */
	public ClienteDAL(AntecedentesPersonales ap)
	{
		this.ap=ap;
	}
	
	
	/**
	 * Metodo que nos conectara a la base de dato y realizara un insert en la tabla vipr_tcliente. 
	 * 
	 * @return Devolvera 1 si se ha realizado el alta satisfactoriamente o un 0 si no se ha realizado
	 */
	public int AltaCliente()
	{
		int insercion = 0;
		c=new Conexion();
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
	
	
	
	/**
	 * Metodo para recoger el ultimo id introducido. Este metodo se llama despues de dar de alta el cliente 
	 * satisfactoriamente para saber su id.
	 * @return nos devuelve la ultima id del cliente al darlo de alta
	 * @throws SQLException
	 */
	public int obtenerultimoid() throws SQLException
	{
		c=new Conexion();
		int enc=0;
		String query="select oid_cliente from tcliente order by oid_cliente DESC limit 1 ";
				
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
			
			System.err.println("error en buscar ClienteDal.obtenerultimoid "+ e );
		}
		finally {
			c.cerrarConexion();
		}
		return enc;
	}
	
	/**
	 * Metodo que se ejecutara despues de dar de alta un cliente.
	 * Introduciremos los datos de sus antecedentes
	 * 
	 * @return Devolvera 1 si se ha relizado el insert o un 0 si se produjo un error
	 */
	public int AltaAntecedentesPersonales()
	{
		int insercion = 0;
		c=new Conexion();
		String query="insert into vipr_tantecedentes_personales values (?,?,?,?,?,?)";
		
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
	
	
	
	
	
}