package Entidades;

public class Exploracion {
	
	private int oid_exploraci�n;
	private String InspeccionVisual;
	private String Palpaci�n;
	private String TestDeMovilidad;
	private String TestOrtopedico;
	
	public int getOid_exploraci�n() {
		return oid_exploraci�n;
	}
	public void setOid_exploraci�n(int oid_exploraci�n) {
		this.oid_exploraci�n = oid_exploraci�n;
	}
	public String getInspeccionVisual() {
		return InspeccionVisual;
	}
	public void setInspeccionVisual(String inspeccionVisual) {
		InspeccionVisual = inspeccionVisual;
	}
	public String getPalpaci�n() {
		return Palpaci�n;
	}
	public void setPalpaci�n(String palpaci�n) {
		Palpaci�n = palpaci�n;
	}
	public String getTestDeMovilidad() {
		return TestDeMovilidad;
	}
	public void setTestDeMovilidad(String testDeMovilidad) {
		TestDeMovilidad = testDeMovilidad;
	}
	public String getTestOrtopedico() {
		return TestOrtopedico;
	}
	public void setTestOrtopedico(String testOrtopedico) {
		TestOrtopedico = testOrtopedico;
	}
	
	@Override
	public String toString() {
		return "Exploracion [oid_exploraci�n=" + oid_exploraci�n + ", InspeccionVisual=" + InspeccionVisual
				+ ", Palpaci�n=" + Palpaci�n + ", TestDeMovilidad=" + TestDeMovilidad + ", TestOrtopedico="
				+ TestOrtopedico + "]";
	}

}
