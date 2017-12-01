package Entidades;

public class Anamnesis {
	
	
	
	private int oid_anamnesis;
	private int oid_cliente;
	private String quelepasa;
	private String desdecuando;
	private String aqueloatribuye;
	private NaturalezaDelDolor naturalezadeldolor;
	private CincoElementos cincoelementos;
	
	
	public String getQuelepasa() {
		return quelepasa;
	}
	public void setQuelepasa(String quelepasa) {
		this.quelepasa = quelepasa;
	}
	public String getDesdecuando() {
		return desdecuando;
	}
	public void setDesdecuando(String desdecuando) {
		this.desdecuando = desdecuando;
	}
	public String getAqueloatribuye() {
		return aqueloatribuye;
	}
	public void setAqueloatribuye(String aqueloatribuye) {
		this.aqueloatribuye = aqueloatribuye;
	}
	public NaturalezaDelDolor getNaturalezadeldolor() {
		return naturalezadeldolor;
	}
	public void setNaturalezadeldolor(NaturalezaDelDolor naturalezadeldolor) {
		this.naturalezadeldolor = naturalezadeldolor;
	}
	public CincoElementos getCincoelementos() {
		return cincoelementos;
	}
	public void setCincoelementos(CincoElementos cincoelementos) {
		this.cincoelementos = cincoelementos;
	}
	

	public int getOid_anamnesis() {
		return oid_anamnesis;
	}
	public void setOid_anamnesis(int oid_anamnesis) {
		this.oid_anamnesis = oid_anamnesis;
	}
	
	public int getOid_cliente() {
		return oid_cliente;
	}
	public void setOid_cliente(int oid_cliente) {
		this.oid_cliente = oid_cliente;
	}
	@Override
	public String toString() {
		return "Anamnesis [oid_anamnesis=" + oid_anamnesis + ", oid_cliente=" + oid_cliente + ", quelepasa=" + quelepasa
				+ ", desdecuando=" + desdecuando + ", aqueloatribuye=" + aqueloatribuye + ", naturalezadeldolor="
				+ naturalezadeldolor + ", cincoelementos=" + cincoelementos + "]";
	}
	
	

}
