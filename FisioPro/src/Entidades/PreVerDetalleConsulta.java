package Entidades;

public class PreVerDetalleConsulta {
	
	private int oid_consulta;
	private String nombrecliente;
	private String apellido1;
	private String quelepasa;
	private String tratamiento;
	private String fecha;
	
	// ids de los formularios
	private int oid_anamnesis;
	private int oid_exploración;
	private int oid_tratamiento;
	
	
	public int getOid_consulta() {
		return oid_consulta;
	}
	public void setOid_consulta(int oid_consulta) {
		this.oid_consulta = oid_consulta;
	}
	public String getNombrecliente() {
		return nombrecliente;
	}
	public void setNombrecliente(String nombrecliente) {
		this.nombrecliente = nombrecliente;
	}
	public String getApellido1() {
		return apellido1;
	}
	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}
	public String getQuelepasa() {
		return quelepasa;
	}
	public void setQuelepasa(String quelepasa) {
		this.quelepasa = quelepasa;
	}
	public String getTratamiento() {
		return tratamiento;
	}
	public void setTratamiento(String tratamiento) {
		this.tratamiento = tratamiento;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	
	public int getOid_anamnesis() {
		return oid_anamnesis;
	}
	public void setOid_anamnesis(int oid_anamnesis) {
		this.oid_anamnesis = oid_anamnesis;
	}
	public int getOid_exploración() {
		return oid_exploración;
	}
	public void setOid_exploración(int oid_exploración) {
		this.oid_exploración = oid_exploración;
	}
	public int getOid_tratamiento() {
		return oid_tratamiento;
	}
	public void setOid_tratamiento(int oid_tratamiento) {
		this.oid_tratamiento = oid_tratamiento;
	}
	@Override
	public String toString() {
		return "PreVerDetalleConsulta [oid_consulta=" + oid_consulta + ", nombrecliente=" + nombrecliente
				+ ", apellido1=" + apellido1 + ", quelepasa=" + quelepasa + ", tratamiento=" + tratamiento + ", fecha="
				+ fecha + ", oid_anamnesis=" + oid_anamnesis + ", oid_exploración=" + oid_exploración
				+ ", oid_tratamiento=" + oid_tratamiento + "]";
	}
	
	
	

}
