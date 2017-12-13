package BLL;

import java.sql.SQLException;
import java.util.List;

import BD.HorariosDAL;
import Entidades.Horarios;

public class HorariosBLL {

	private Horarios horario;
	
	
	public HorariosBLL() {
	
	}


	public List<Horarios> horariosdisponibles(String fecha) throws SQLException {
		HorariosDAL horariodal=new HorariosDAL();
		return horariodal.obtenerhorariosdisponibles(fecha);
	}
}
