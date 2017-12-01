package BLL;

import java.sql.SQLException;

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
		AnamnesisDAL anamdal=new AnamnesisDAL(an,cli);
		return anamdal.AltaAnamnesis();
	}
	
	public int obtenerultimoid() throws SQLException
	{
		AnamnesisDAL anamdal=new AnamnesisDAL();
		return anamdal.obtenerultimoid();
	}

}
