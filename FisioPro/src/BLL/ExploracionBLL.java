package BLL;

import java.sql.SQLException;

import BD.*;
import Entidades.*;

public class ExploracionBLL {
	
	private Exploracion exp;

	public ExploracionBLL()
	{
		
	}
	public ExploracionBLL (Exploracion tra)
	{
		this.exp=new Exploracion();
		this.exp=tra;
	}
	
	public int AltaExploracion()
	{
		ExploracionDAL traDAL=new ExploracionDAL(exp);
		return traDAL.AltaExploracion();
	}
	
	public int obtenerultimoid() throws SQLException
	{
		ExploracionDAL traDAL=new ExploracionDAL(exp);
		return traDAL.obtenerultimoid();
	}
	

}
