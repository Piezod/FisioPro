package BLL;

import java.sql.SQLException;

import BD.*;
import Entidades.*;

public class TratamientoBLL {

	private Tratamiento tra;

	public TratamientoBLL()
	{
		
	}
	public TratamientoBLL (Tratamiento tra)
	{
		this.tra=new Tratamiento();
		this.tra=tra;
	}
	
	public int AltaTratamiento()
	{
		TratamientoDAL traDAL=new TratamientoDAL(tra);
		return traDAL.AltaExploracion();
	}
	
	public int obtenerultimoid() throws SQLException
	{
		TratamientoDAL traDAL=new TratamientoDAL(tra);
		return traDAL.obtenerultimoid();
	}

	public Tratamiento RellenarTratamiento() {
		TratamientoDAL tradal=new TratamientoDAL(tra);
		
		return tradal.RellenarTratamiento(""+tra.getOid_tratamiento());
	}
	
}
