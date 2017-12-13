package BD;

import java.beans.Statement;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import Entidades.*;
public class HorariosDAL {

		private Horarios horario;
		private Conexion c;
		
		public List<Horarios> obtenerhorariosdisponibles(String fecha) throws SQLException
		{
			c=new Conexion();
			int enc=0;
			String query="select *"
					+ " from vipr_thorario "
					+ "where oid_horario not in "
					+ "         (Select oid_horario from vipr_tcita as cita "
					+ "          where fecha like '"+fecha+"')";
					
			List<Horarios> listahorariosdisponibles=new ArrayList<>();
			try {
				ResultSet rs=c.getstm().executeQuery(query);
				while (rs.next())
				{
					Horarios h=new Horarios();
					h.setOid_horario(rs.getInt(1));
					h.setFyh_hinicio(rs.getInt(2));
					h.setFyh_hfin(rs.getInt(3));
					h.setDes_horario(rs.getString(4));
					listahorariosdisponibles.add(h);
				}

			} catch (Exception e) {
				// TODO: handle exception
				
				System.err.println("error en buscar HorariosDAL.obtenerhorariosdisponibles "+ e );
			}
			finally {
				c.cerrarConexion();
			}
			return listahorariosdisponibles;
		}
		
	}



