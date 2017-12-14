package Entidades;

public class DetalleCita {
	
	private String nombre;
	private String apellido1;
	private String apellido2;
	private String des_horario;
	private int numerocitas;
	private int oid_cita;
	private int bol_activa;
	private int oid_cliente;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido1() {
		return apellido1;
	}
	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}
	public String getApellido2() {
		return apellido2;
	}
	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}
	public String getDes_horario() {
		return des_horario;
	}
	public void setDes_horario(String des_horario) {
		this.des_horario = des_horario;
	}

	public int getNumerocitas() {
		return numerocitas;
	}
	public void setNumerocitas(int numerocitas) {
		this.numerocitas = numerocitas;
	}

	
	public int getOid_cita() {
		return oid_cita;
	}
	public void setOid_cita(int oid_cita) {
		this.oid_cita = oid_cita;
	}
	public int getBol_activa() {
		return bol_activa;
	}
	public void setBol_activa(int bol_activa) {
		this.bol_activa = bol_activa;
	}
	

	public int getOid_cliente() {
		return oid_cliente;
	}
	public void setOid_cliente(int oid_cliente) {
		this.oid_cliente = oid_cliente;
	}
	
	@Override
	public String toString() {
		return "DetalleCita [nombre=" + nombre + ", apellido1=" + apellido1 + ", apellido2=" + apellido2
				+ ", des_horario=" + des_horario + ", numerocitas=" + numerocitas + ", oid_cita=" + oid_cita
				+ ", bol_activa=" + bol_activa + ", oid_cliente=" + oid_cliente + "]";
	}

}
