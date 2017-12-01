package Entidades;

public class NaturalezaDelDolor {
	
	private int oid_Naturaleza;
	private String Localizacion;
	private String Cronologia; // desplegable (1 dia, menos de 1 mes, mas de 1 mes, + 6 meses
	private String Irradiacion;
	private String Forma; // cb Constante o intermitente
	private String hora; //Lista mañana, largodeldia,finaldetarde,noche
	private String Intensidad; //lista leve,moderado,punzante,sordo,continuo,intermitente,acentua con cansancio
	private String FormaComienzo; // cb agudo o insidioso;
	private String ImpotenciaFuncional; //cb pequeña,media,grande
	private String RelacionTos; 
	private String CambiaLugar; //
	private String FactoresDesencadenantes; // lista,movimientok,reposo,frio,calor,presion,extres
	private String FactoresAliviadores; //lista los mismos.
	public String getLocalizacion() {
		return Localizacion;
	}
	public void setLocalizacion(String localizacion) {
		Localizacion = localizacion;
	}
	public String getCronologia() {
		return Cronologia;
	}
	public void setCronologia(String cronologia) {
		Cronologia = cronologia;
	}
	public String getIrradiacion() {
		return Irradiacion;
	}
	public void setIrradiacion(String irradiacion) {
		Irradiacion = irradiacion;
	}
	public String getForma() {
		return Forma;
	}
	public void setForma(String forma) {
		Forma = forma;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	public String getIntensidad() {
		return Intensidad;
	}
	public void setIntensidad(String intensidad) {
		
		System.out.println(intensidad);
		
		Intensidad = intensidad;
	}
	public String getFormaComienzo() {
		return FormaComienzo;
	}
	public void setFormaComienzo(String formaComienzo) {
		FormaComienzo = formaComienzo;
	}
	public String getImpotenciaFuncional() {
		return ImpotenciaFuncional;
	}
	public void setImpotenciaFuncional(String impotenciaFuncional) {
		ImpotenciaFuncional = impotenciaFuncional;
	}
	public String getRelacionTos() {
		return RelacionTos;
	}
	public void setRelacionTos(String relacionTos) {
		RelacionTos = relacionTos;
	}
	public String getCambiaLugar() {
		return CambiaLugar;
	}
	public void setCambiaLugar(String CambiaLugar) {
		this.CambiaLugar = CambiaLugar;
	}
	public String getFactoresDesencadenantes() {
		return FactoresDesencadenantes;
	}
	public void setFactoresDesencadenantes(String factoresDesencadenantes) {
		FactoresDesencadenantes = factoresDesencadenantes;
	}
	public String getFactoresAliviadores() {
		return FactoresAliviadores;
	}
	public void setFactoresAliviadores(String factoresAliviadores) {
		FactoresAliviadores = factoresAliviadores;
	}
	
	@Override
	public String toString() {
		return "NaturalezaDelDolor [oid_Naturaleza=" + oid_Naturaleza + ", Localizacion=" + Localizacion
				+ ", Cronologia=" + Cronologia + ", Irradiacion=" + Irradiacion + ", Forma=" + Forma + ", hora=" + hora
				+ ", Intensidad=" + Intensidad + ", FormaComienzo=" + FormaComienzo + ", ImpotenciaFuncional="
				+ ImpotenciaFuncional + ", RelacionTos=" + RelacionTos + ", Migratorio=" + CambiaLugar
				+ ", FactoresDesencadenantes=" + FactoresDesencadenantes + ", FactoresAliviadores="
				+ FactoresAliviadores + "]";
	}
	public int getOid_Naturaleza() {
		return oid_Naturaleza;
	}
	public void setOid_Naturaleza(int oid_Naturaleza) {
		this.oid_Naturaleza = oid_Naturaleza;
	}
	

}
