package BLL;

import BD.CitaDAL;
import Entidades.Cita;

public class CitaBLL {

	private Cita cita;
	
	public CitaBLL(Cita cita) {
	this.cita=new Cita();
	this.cita=cita;
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
}
