package BLL;

import java.sql.SQLException;
import java.util.List;

import BD.ConsultaDAL;
import BD.ExploracionDAL;
import Entidades.Consulta;
import Entidades.Exploracion;

public class ConsultaBLL {

	private Consulta consul;
	
	public ConsultaBLL() {
		// TODO Auto-generated constructor stub
	}
	public ConsultaBLL(Consulta consul)
	{
		this.consul=consul;
	}
	
	public int AltaConsulta()
	{
		ConsultaDAL conDAL=new ConsultaDAL(consul);
		return conDAL.AltaConsulta();
	}
	
	public int obtenerultimoid() throws SQLException
	{
		ConsultaDAL conDAL=new ConsultaDAL(consul);
		return conDAL.obtenerultimoid();
	}
	public List<Consulta> verconsultashoy() {
		// TODO Auto-generated method stub
		ConsultaDAL conDAL=new ConsultaDAL();
		return conDAL.verconsultashoy();
	}
}
