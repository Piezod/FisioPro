package Entidades;

public class Consulta {
	
	private int oid_consulta;
	private int oid_cliente;
	private int oid_anamnesis;
	private int oid_exploraci�n;
	private int oid_tratamiento;
	private String fecha;
	private String motivo;
	
	
	public int getOid_consulta() {
		return oid_consulta;
	}
	public void setOid_consulta(int oid_consulta) {
		this.oid_consulta = oid_consulta;
	}
	public int getOid_cliente() {
		return oid_cliente;
	}
	public void setOid_cliente(int oid_cliente) {
		this.oid_cliente = oid_cliente;
	}
	public int getOid_anamnesis() {
		return oid_anamnesis;
	}
	public void setOid_anamnesis(int oid_anamnesis) {
		this.oid_anamnesis = oid_anamnesis;
	}
	public int getOid_exploraci�n() {
		return oid_exploraci�n;
	}
	public void setOid_exploraci�n(int oid_exploraci�n) {
		this.oid_exploraci�n = oid_exploraci�n;
	}
	public int getOid_tratamiento() {
		return oid_tratamiento;
	}
	public void setOid_tratamiento(int oid_tratamiento) {
		this.oid_tratamiento = oid_tratamiento;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getMotivo() {
		return motivo;
	}
	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}
	
	@Override
	public String toString() {
		return "Consulta [oid_consulta=" + oid_consulta + ", oid_cliente=" + oid_cliente + ", oid_anamnesis="
				+ oid_anamnesis + ", oid_exploraci�n=" + oid_exploraci�n + ", oid_tratamiento=" + oid_tratamiento
				+ ", fecha=" + fecha + ", motivo=" + motivo + "]";
	}

}
