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
import Entidades.NaturalezaDelDolor;

public class NaturalezaDAL {

	private NaturalezaDelDolor natu;
	private Anamnesis anam;
	private Conexion c;
	
	/*
	 *  Tabla : tcliente
	 *  Campos : oid_cliente,nombre,apellido,apellido2,edad,telefono.
	 */
	
	/**
	 * Constructor para realizar el alta y require el objeto naturaleza con los datos del jsp y el
	 * id del formulario de anamnesis
	 * @param AnamnesisDAL
	 */
	public NaturalezaDAL(NaturalezaDelDolor natu,Anamnesis anam) {
		
		this.anam=new Anamnesis();
		this.natu=new NaturalezaDelDolor();
		
		this.natu=natu;
		this.anam=anam;
	}
	
	public NaturalezaDAL()
	{
		
	}

	/**
	 * MEtodo para realizar el alta del formulario de NaturalezaDelDolor
	 * en el realizaremos el insert de los datos recogidos en la jsp y el id del formulario anterior
	 * anamnesis 
	 * 
	 * @return Devolvera 1 si se ha realizado el alta satisfactoriamente o un 0 si no se ha realizado
	 */
	
	public int AltaNaturaleza()
	{
		/*  1� oid_naturaleza, 2� oid_anamnesis, 3� localizacion, 4� cronologia,5� irradiacion
		 *  6� forma, 7� hora, 8� intensidad, 9� formadecomienzo, 10� tos, 11� desencadenante,
		 *  12� aliviadores, 13� impotencia, 14� cambialugar
		 */
		int insercion = 0;
		c=new Conexion();
		String query="insert into vipr_tnaturaleza values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		
		try {
			PreparedStatement psResulset = c.getConexion().prepareStatement(query);
			psResulset.setInt(1,0); // Este campo es autoincremental en la bd
			psResulset.setInt(2,(anam.getOid_anamnesis()));
			psResulset.setString(3, natu.getLocalizacion());
			psResulset.setString(4, natu.getCronologia());
			psResulset.setString(5, natu.getIrradiacion());
			psResulset.setString(6, natu.getForma());
			psResulset.setString(7, natu.getHora());
			psResulset.setString(8, natu.getIntensidad());
			psResulset.setString(9, natu.getFormaComienzo());
			psResulset.setString(10, natu.getRelacionTos());
			psResulset.setString(11, natu.getFactoresDesencadenantes());
			psResulset.setString(12, natu.getFactoresAliviadores());
			psResulset.setString(13, natu.getImpotenciaFuncional());
			psResulset.setString(14, natu.getCambiaLugar());
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
	 * Metodo para recoger el ultimo id introducido. Este metodo se llama despues de dar de alta.
	 * @return nos devuelve la ultima id del cliente al darlo de alta
	 * @throws SQLException
	 */
	public int obtenerultimoid() throws SQLException
	{
		c=new Conexion();
		int enc=0;
		String query="select oid_naturaleza from vipr_tnaturaleza order by oid_naturaleza DESC limit 1 ";
				
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
			
			System.err.println("error en buscar naturalezaDAL.Obtenerultimoid "+ e );
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
			
			System.err.println("error en buscar ClienteDal.RellenarCliente "+ e.getLocalizedMessage() );
		}
		finally {
			c.cerrarConexion();
		}
		
		return auxcli;
	}
	
}