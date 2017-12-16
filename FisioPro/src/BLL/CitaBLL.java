package BLL;

import java.util.List;

import BD.CitaDAL;
import Entidades.Cita;
import Entidades.DetalleCita;

public class CitaBLL {

	private Cita cita;
	
	public CitaBLL(Cita cita) {
	this.cita=new Cita();
	this.cita=cita;
	}
	
	public CitaBLL()
	{
		
	}
	
	
public int CrearCita()
{
	CitaDAL citadal=new CitaDAL(cita);
	if (AlgunValorVacio())
	return citadal.CrearCita();
		else
		return 0;
}

public boolean AlgunValorVacio()
{
	if (Utilidades.EsNulo(cita.getOid_cliente())
		||Utilidades.EsNulo(cita.getOid_horario())
			||Utilidades.EsNulo(cita.getFecha()))
	{
		return false;
	}
	else return true;
}

/** Ver citas para hoy
 * @return Devuelve una lista con las citas activas en el dia de hoy
 */
public List<DetalleCita> citasparahoy()
{
	DetalleCita dc=new DetalleCita();
	CitaDAL citadal=new CitaDAL();
	
	return citadal.citasparahoy();
	
}

/** Metodo para cancelar la cita segun la id recogida en el objeto cita
 * @return
 */
public int cancelarcita() {
	
	CitaDAL citadal=new CitaDAL(cita);
	return citadal.cancelarcita();
}


/** Metodo para devolver una lista con el detalle de celdas de una fecha en concreta
 * @return
 */
public List<DetalleCita> listacitasfecha(String fecha) {
	
	DetalleCita dc=new DetalleCita();
	CitaDAL citadal=new CitaDAL();
	
	return citadal.listacitasfecha(fecha);
}
}
