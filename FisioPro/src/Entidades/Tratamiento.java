package Entidades;

public class Tratamiento {

	private int oid_tratamiento;
	private String tratamiento;
	public int getOid_tratamiento() {
		return oid_tratamiento;
	}
	public void setOid_tratamiento(int oid_tratamiento) {
		this.oid_tratamiento = oid_tratamiento;
	}
	public String getTratamiento() {
		return tratamiento;
	}
	public void setTratamiento(String tratamiento) {
		this.tratamiento = tratamiento;
	}
	@Override
	public String toString() {
		return "Tratamiento [oid_tratamiento=" + oid_tratamiento + ", tratamiento=" + tratamiento + "]";
	}
	
	
}
