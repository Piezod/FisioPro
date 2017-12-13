package Entidades;

public class Cita {

	private int oid_cita;
	private int oid_cliente;
	private int oid_horario;
	private String fecha;
	
	public int getOid_cita() {
		return oid_cita;
	}
	public void setOid_cita(int oid_cita) {
		this.oid_cita = oid_cita;
	}
	public int getOid_cliente() {
		return oid_cliente;
	}
	public void setOid_cliente(int oid_cliente) {
		this.oid_cliente = oid_cliente;
	}
	public int getOid_horario() {
		return oid_horario;
	}
	public void setOid_horario(int oid_horario) {
		this.oid_horario = oid_horario;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
	@Override
	public String toString() {
		return "Cita [oid_cita=" + oid_cita + ", oid_cliente=" + oid_cliente + ", oid_horario=" + oid_horario
				+ ", fecha=" + fecha + "]";
	}
}
