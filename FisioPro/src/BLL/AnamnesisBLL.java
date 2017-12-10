package BLL;

import java.sql.SQLException;

import com.mysql.jdbc.Util;

import BD.AnamnesisDAL;
import Entidades.Anamnesis;
import Entidades.Cliente;

public class AnamnesisBLL {
	
	private Anamnesis an;
	
	public AnamnesisBLL() {
		// TODO Auto-generated constructor stub
	}
	
	public AnamnesisBLL(String oid_anamnesis,String oid_cliente, String quelepasa,String desdecuando,String aqueloatribuye)
	{
		an=new Anamnesis();
		an.setOid_cliente(Integer.parseInt(oid_cliente));
		an.setOid_anamnesis(Integer.parseInt(oid_anamnesis));
		an.setAqueloatribuye(aqueloatribuye);
		an.setDesdecuando(desdecuando);
		an.setQuelepasa(quelepasa);
		
	}
	
	public AnamnesisBLL (Anamnesis anam)
	{
		an=new Anamnesis();
		this.an=anam;
	}
	
	public int altaanamnesisBLL(String oid_cliente)
	{
		Cliente cli=new Cliente();
		cli.setOid(Integer.parseInt(oid_cliente));
		forzarvacios();
		AnamnesisDAL anamdal=new AnamnesisDAL(an,cli);		
		return anamdal.AltaAnamnesis();
	}
	
	public int obtenerultimoid() throws SQLException
	{
		AnamnesisDAL anamdal=new AnamnesisDAL();
		return anamdal.obtenerultimoid();
	}

	private void forzarvacios()
	{
		if(Utilidades.EsVacia(an.getQuelepasa()))
		{
			an.setQuelepasa("No sabe");
		}
		if (Utilidades.EsVacia(an.getDesdecuando()))
		{
			an.setDesdecuando("No sabe");
		}
		if (Utilidades.EsVacia(an.getAqueloatribuye()))
		{
			an.setAqueloatribuye("No sabe");
		}
	}

	/** Metodo para rellenar un bean de datos 
	 * @return Un objeto tipo anamnesis relleno de datos
	 */
	public Anamnesis rellenaranamnesis()
	{
		AnamnesisDAL anamdal=new AnamnesisDAL();
		
		return anamdal.RellenarAnamnesis(""+an.getOid_anamnesis()); 
	}
}
