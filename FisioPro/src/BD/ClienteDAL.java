package BD;

import java.beans.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Entidades.AntecedentesPersonales;
import Entidades.Cliente;

public class ClienteDAL {

	
	
	private Cliente cli;
	private Conexion c;
	private AntecedentesPersonales ap;
	
	/*
	 *  Tabla : tcliente
	 *  Campos : oid_cliente,des_nombre,des_apellido1,des_apellido2,edad,telefono.
	 */
	
	/**
	 * Constructor para ejecutar cosas relativas al cliente propiamente dicho
	 * @param cli
	 */
	public ClienteDAL(Cliente cli) {
		
		this.cli=cli;
		
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Si tengo que hacer consultas pero no se NADA del cliente es muy util, por ejemplo para rellenar
	 * el combobox de todos los clientes
	 */
	public ClienteDAL()
	{
		
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
	
	/** Metodo que recorrera la tabla de vipr_tcliente en busqueda de
	 * clientes con el nombre like '%nombre%'
	 * 
	 * @return Devolvera una lista con los clientes encontrados, en caso
	 * de que no encuentre nada, devolvera la lista con valor null,
	 */
	public List<Cliente> buscarclientes()
	{
		List<Cliente> listcliente=new ArrayList();
		
		c=new Conexion();
		String query="select * from tcliente where des_nombre like '%"+cli.getNombre()+"%' order by oid_cliente";
				
		try {
			
			ResultSet rs=c.getstm().executeQuery(query);

			while (rs.next())
			{
				Cliente auxcli=new Cliente();
				auxcli.setOid(rs.getInt(1));
				auxcli.setNombre(rs.getString(2));
				auxcli.setApellido1(rs.getString(3));
				auxcli.setApellido2(rs.getString(4));
				auxcli.setEdad(rs.getString(5));
				auxcli.setTelefono(rs.getString(6));
				listcliente.add(auxcli);
			}
			
						
		} catch (Exception e) {
			// TODO: handle exception
			
			System.err.println("error en buscar ClienteDal.obtenerultimoid "+ e.getLocalizedMessage() );
		}
		finally {
			c.cerrarConexion();
		}
		
		return listcliente;
	}
	
	/** Metodo para rellenar un bean Cliente 
	 * @param cli Se le pasa el id del cliente a través de un objeto bean que sera relleno
	 * @return un objeto tipo Cliente con toda la información basica recargada
	 */
	public Cliente RellenarCliente (String cli)
	{
		Cliente auxcli=new Cliente();
		auxcli.setOid(Integer.parseInt(cli));
		c=new Conexion();
		String query="select * from tcliente where oid_cliente = '"+auxcli.getOid()+"'";
				
		try {
			
			ResultSet rs=c.getstm().executeQuery(query);
			while (rs.next())
			{
				
				auxcli.setNombre(rs.getString(2));
				auxcli.setApellido1(rs.getString(3));
				auxcli.setApellido2(rs.getString(4));
				auxcli.setEdad(rs.getString(5));
				auxcli.setTelefono(rs.getString(6));
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			
			System.err.println("error en buscar ClienteDal.RellenarCliente "+ e.getLocalizedMessage() );
		}
		finally {
			c.cerrarConexion();
		}
		
		return auxcli;
	}
	
	/**Metodo que nos devolvera TODOS los clientes
	 * @return Lista de tipo cliente con los datos de todos nuestros clientes almacenados.
	 */
	public List<Cliente> RecargarTodosCliente ()
	{
		List<Cliente> listcliente=new ArrayList();
		
		c=new Conexion();
		String query="select * from tcliente order by des_nombre";
				
		try {
			
			ResultSet rs=c.getstm().executeQuery(query);

			while (rs.next())
			{
				Cliente auxcli=new Cliente();
				auxcli.setOid(rs.getInt(1));
				auxcli.setNombre(rs.getString(2));
				auxcli.setApellido1(rs.getString(3));
				auxcli.setApellido2(rs.getString(4));
				auxcli.setEdad(rs.getString(5));
				auxcli.setTelefono(rs.getString(6));
				listcliente.add(auxcli);
			}
			
						
		} catch (Exception e) {
			// TODO: handle exception
			
			System.err.println("error en buscar ClienteDal.RecargarTodosCliente "+ e.getLocalizedMessage() );
		}
		finally {
			c.cerrarConexion();
		}
		
		return listcliente;
	}
}