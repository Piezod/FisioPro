package Entidades;

public class Horarios {

	private int oid_horario;
	private int fyh_hinicio;
	private int fyh_hfin;
	private String des_horario;
	
	
	public int getOid_horario() {
		return oid_horario;
	}
	public void setOid_horario(int oid_horario) {
		this.oid_horario = oid_horario;
	}
	public int getFyh_hinicio() {
		return fyh_hinicio;
	}
	public void setFyh_hinicio(int fyh_hinicio) {
		this.fyh_hinicio = fyh_hinicio;
	}
	public int getFyh_hfin() {
		return fyh_hfin;
	}
	public void setFyh_hfin(int fyh_hfin) {
		this.fyh_hfin = fyh_hfin;
	}
	public String getDes_horario() {
		return des_horario;
	}
	public void setDes_horario(String des_horario) {
		this.des_horario = des_horario;
	}
	@Override
	public String toString() {
		return "Horarios [oid_horario=" + oid_horario + ", fyh_hinicio=" + fyh_hinicio + ", fyh_hfin=" + fyh_hfin
				+ ", des_horario=" + des_horario + "]";
	}
}
