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
		/*  1º oid_naturaleza, 2º oid_anamnesis, 3º localizacion, 4º cronologia,5º irradiacion
		 *  6º forma, 7º hora, 8º intensidad, 9º formadecomienzo, 10º tos, 11º desencadenante,
		 *  12º aliviadores, 13º impotencia, 14º cambialugar
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
	public NaturalezaDelDolor RellenarNaturaleza (NaturalezaDelDolor natu)
	{
		
		c=new Conexion();
		String query="SELECT `oid_naturaleza`"
				+ ", `oid_anamnesis`"
				+ ", `localizacion`"
				+ ", `cronologia`"
				+ ", `irradiacion`"
				+ ", `forma`"
				+ ", `hora`"
				+ ", `intensidad`"
				+ ", `formadecomienzo`"
				+ ", `tos`"
				+ ", `desencadenante`"
				+ ", `aliviadores`"
				+ ", `impotencia`"
				+ ", `cambialugar`"
				+ " FROM `vipr_tnaturaleza`"
				+ " WHERE oid_naturaleza = "+natu.getOid_Naturaleza();
				
		try {
			
			ResultSet rs=c.getstm().executeQuery(query);
			while (rs.next())
			{
				
				natu.setLocalizacion(rs.getString(3));
				natu.setCronologia(rs.getString(4));
				natu.setIrradiacion(rs.getString(5));
				natu.setForma(rs.getString(6));
				natu.setHora(rs.getString(7));
				natu.setIntensidad(rs.getString(8));
				natu.setFormaComienzo(rs.getString(9));
				natu.setRelacionTos(rs.getString(10));
				natu.setFactoresDesencadenantes(rs.getString(11));
				natu.setFactoresAliviadores(rs.getString(12));
				natu.setImpotenciaFuncional(rs.getString(13));
				natu.setCambiaLugar(rs.getString(14));
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			
			System.err.println("error en buscar ClienteDal.RellenarCliente "+ e.getLocalizedMessage() );
		}
		finally {
			c.cerrarConexion();
		}
		
		return natu;
	}
	
}