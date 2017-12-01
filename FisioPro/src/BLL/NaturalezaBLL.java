package BLL;

import java.sql.SQLException;

import javax.rmi.CORBA.Util;

import BD.NaturalezaDAL;
import Entidades.Anamnesis;
import Entidades.Cliente;
import Entidades.NaturalezaDelDolor;

public class NaturalezaBLL {
	
	private NaturalezaDelDolor natu;
	
	public NaturalezaBLL() {
		// TODO Auto-generated constructor stub
	}

	
	public NaturalezaBLL (NaturalezaDelDolor natu)
	{
		this.natu=new NaturalezaDelDolor();
		this.natu=natu;

		/*
		 * Validamos que los datos que vengan no esten vacios, en caso de que esten vacios
		 * les damos un valor por defecto.
		 */
		validardatos();
	}
	
	public int altaNaturalezaBLL(int oid_anamnesis)
	{
		
		Anamnesis anam=new Anamnesis();
		anam.setOid_anamnesis((oid_anamnesis));
		NaturalezaDAL natudal=new NaturalezaDAL(natu,anam);
		return natudal.AltaNaturaleza();
	}
	
	public int obtenerultimoid() throws SQLException
	{
		NaturalezaDAL natudal=new NaturalezaDAL();
		return natudal.obtenerultimoid();
	}
	
	public void validardatos()
	{
		if (Utilidades.EsNulo(natu.getLocalizacion()))
		{
			natu.setLocalizacion("no sabe");
		}
		if (Utilidades.EsNulo(natu.getIrradiacion()))
		{
			natu.setIrradiacion("no sabe");
		}
		if (Utilidades.EsNulo(natu.getHora()))
		{
			natu.setHora("No sabe");
		}
		if (Utilidades.EsNulo(natu.getIntensidad()))
		{
			natu.setIntensidad("No sabe");
		}
		if (Utilidades.EsNulo(natu.getFormaComienzo()))
		{
			natu.setFormaComienzo("No sabe");
		}
		if (Utilidades.EsNulo(natu.getRelacionTos()))
		{
			natu.setRelacionTos("No sabe");
		}
		if (Utilidades.EsNulo(natu.getFactoresDesencadenantes()))
		{
			natu.setFactoresDesencadenantes("No sabe");
		}
		if (Utilidades.EsNulo(natu.getFactoresAliviadores()))
		{
			natu.setFactoresAliviadores("No sabe");
		}
		if (Utilidades.EsNulo(natu.getImpotenciaFuncional())) {
			natu.setImpotenciaFuncional("No sabe");
		}
		if (Utilidades.EsNulo(natu.getCambiaLugar()))
		{
			natu.setCambiaLugar("No sabe");
		}
		
		
	}

}
