package BLL;

import java.sql.SQLException;
import java.util.List;

import com.sun.org.apache.bcel.internal.generic.RETURN;

import BD.ConsultaDAL;
import BD.ExploracionDAL;
import Entidades.Consulta;
import Entidades.DetalleConsulta;
import Entidades.Exploracion;
import Entidades.PreVerDetalleConsulta;

public class ConsultaBLL {

	private Consulta consul;
	
	public ConsultaBLL() {
		// TODO Auto-generated constructor stub
	}
	public ConsultaBLL(Consulta consul)
	{
		this.consul=consul;
	}
	public ConsultaBLL(String idcliente)
	{
		consul=new Consulta();
		consul.setOid_cliente(Integer.parseInt(idcliente));
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

	/**
	 * Metodo que devuelve los datos puros de una consulta
	 * @return
	 * 
	 */
	public List<Consulta> verconsultashoy() {
		// TODO Auto-generated method stub
		ConsultaDAL conDAL=new ConsultaDAL();
		return conDAL.verconsultashoy();
	}
	
	public List<DetalleConsulta> rellenarconsultaporcliente()
	{
		ConsultaDAL consuldal=new ConsultaDAL();
		return consuldal.rellenarconsultaporcliente(consul);				
	}

	public List<PreVerDetalleConsulta> preverdetalleconsultas()
	{
		ConsultaDAL consuldal=new ConsultaDAL(consul);
		return consuldal.preverdetalleconsultas();
	}
}
