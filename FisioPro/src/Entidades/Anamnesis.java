package Entidades;

public class Anamnesis {
	
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
	
	@Override
	public String toString() {
		return "Anamnesis [quelepasa=" + quelepasa + ", desdecuando=" + desdecuando + ", aqueloatribuye="
				+ aqueloatribuye + ", naturalezadeldolor=" + naturalezadeldolor + ", cincoelementos=" + cincoelementos
				+ "]";
	}
	
	

}
