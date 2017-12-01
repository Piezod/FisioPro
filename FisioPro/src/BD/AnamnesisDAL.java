package BD;

import java.beans.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Entidades.Anamnesis;
import Entidades.AntecedentesPersonales;
import Entidades.Cliente;

public class AnamnesisDAL {

	private Anamnesis anam;
	private Cliente cli;
	private Conexion c;
	
	/*
	 *  Tabla : tcliente
	 *  Campos : oid_cliente,nombre,apellido,apellido2,edad,telefono.
	 */
	
	/**
	 * Constructor para ejecutar cosas relativas al AnamnesisDAL propiamente dicho
	 * @param AnamnesisDAL
	 */
	public AnamnesisDAL(Anamnesis anam, Cliente cli) {
		
		this.anam=new Anamnesis();
		this.anam=anam;
		this.cli=cli;
	}
	
	public AnamnesisDAL()
	{
		
	}

	
	/**
	 * MEtodo para realizar el alta del formulario de anamnesis 
	 * 
	 * @return Devolvera 1 si se ha realizado el alta satisfactoriamente o un 0 si no se ha realizado
	 */
	
	public int AltaAnamnesis()
	{
		int insercion = 0;
		c=new Conexion();
		String query="insert into vipr_tanamnesis values (?,?,?,?,?)";
		
		try {
			PreparedStatement psResulset = c.getConexion().prepareStatement(query);
			psResulset.setInt(1,0); // Este campo es autoincremental en la bd
			psResulset.setInt(2,(cli.getOid()));
			psResulset.setString(3, anam.getQuelepasa());
			psResulset.setString(4, anam.getDesdecuando());
			psResulset.setString(5, anam.getAqueloatribuye());
			insercion=psResulset.executeUpdate();
						 
		} catch (SQLException e) {
			// TODO: handle exception
			System.err.println("error en buscar Anamneseisdal.AltaAnamnesis al realizar el insert" + e);
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
		String query="select oid_anamnesis from vipr_tanamnesis order by oid_anamnesis DESC limit 1 ";
				
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
			
			System.err.println("error en buscar AnamnesisDAL.Obtenerultimoid "+ e );
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
	public List<Cliente> susio()
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
			
			System.err.println("error en buscar ClienteDal.RellenarCliente "+ e.getLocalizedMessage() );
		}
		finally {
			c.cerrarConexion();
		}
		
		return auxcli;
	}
	
}