package Entidades;

public class Exploracion {
	
	private int oid_exploración;
	private String InspeccionVisual;
	private String Palpación;
	private String TestDeMovilidad;
	private String TestOrtopedico;
	
	public int getOid_exploración() {
		return oid_exploración;
	}
	public void setOid_exploración(int oid_exploración) {
		this.oid_exploración = oid_exploración;
	}
	public String getInspeccionVisual() {
		return InspeccionVisual;
	}
	public void setInspeccionVisual(String inspeccionVisual) {
		InspeccionVisual = inspeccionVisual;
	}
	public String getPalpación() {
		return Palpación;
	}
	public void setPalpación(String palpación) {
		Palpación = palpación;
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
		return "Exploracion [oid_exploración=" + oid_exploración + ", InspeccionVisual=" + InspeccionVisual
				+ ", Palpación=" + Palpación + ", TestDeMovilidad=" + TestDeMovilidad + ", TestOrtopedico="
				+ TestOrtopedico + "]";
	}

}
