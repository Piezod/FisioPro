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
		forzarvacios();
	}
	
	public int AltaExploracion()
	{
		/*
		 * Modificamos los campos para que guarde el salto de linea para visualizarlo bien en html
		 */
		exp.setInspeccionVisual(exp.getInspeccionVisual().replaceAll("\n","<br />")); 
		exp.setPalpación(exp.getPalpación().replaceAll("\n","<br />")); 
		exp.setTestDeMovilidad(exp.getTestDeMovilidad().replaceAll("\n","<br />")); 
		exp.setTestOrtopedico(exp.getTestOrtopedico().replaceAll("\n","<br />"));
		
		ExploracionDAL traDAL=new ExploracionDAL(exp);
		return traDAL.AltaExploracion();
	}
	
	public int obtenerultimoid() throws SQLException
	{
		ExploracionDAL traDAL=new ExploracionDAL(exp);
		return traDAL.obtenerultimoid();
	}
	public Exploracion RellenarExploracion() {
		
		ExploracionDAL anamdal=new ExploracionDAL();
		
		return anamdal.RellenarExploracion(""+exp.getOid_exploración()); 
	}
	
	/**
	 * Metodo para ver si hay algun campo que este vacio, lo rellenamos con un valor por defecto
	 * 
	 */
	private void forzarvacios()
	{
		if (Utilidades.EsNulo(exp.getInspeccionVisual())||Utilidades.EsVacia(exp.getInspeccionVisual()))
		{
			exp.setInspeccionVisual("Ninguna");
		}
		if (Utilidades.EsNulo(exp.getPalpación())||Utilidades.EsVacia(exp.getPalpación()))
		{
			exp.setPalpación("Ninguna");
		}
		if (Utilidades.EsNulo(exp.getTestDeMovilidad())||Utilidades.EsVacia(exp.getTestDeMovilidad()))
		{
			exp.setTestDeMovilidad("Ninguna");
		}
		if (Utilidades.EsNulo(exp.getTestOrtopedico())||Utilidades.EsVacia(exp.getTestOrtopedico()))
		{
			exp.setTestOrtopedico("Ninguna");
		}
	}

}
