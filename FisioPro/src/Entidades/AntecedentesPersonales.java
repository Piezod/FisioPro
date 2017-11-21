package Entidades;

public class AntecedentesPersonales {
	private String EnfermedadesGraves;
	private String OperacionesQuirurjicas;
	private String TratamientoMedicoActual;
	private String LesionesAntiguas;
	private int oid_cliente;
	
	public String getEnfermedadesGraves() {
		return EnfermedadesGraves;
	}
	public void setEnfermedadesGraves(String enfermedadesGraves) {
		EnfermedadesGraves = enfermedadesGraves;
	}
	public String getOperacionesQuirurjicas() {
		return OperacionesQuirurjicas;
	}
	public void setOperacionesQuirurjicas(String operacionesQuirurjicas) {
		OperacionesQuirurjicas = operacionesQuirurjicas;
	}
	public String getTratamientoMedicoActual() {
		return TratamientoMedicoActual;
	}
	public void setTratamientoMedicoActual(String tratamientoMedicoActual) {
		TratamientoMedicoActual = tratamientoMedicoActual;
	}
	public String getLesionesAntiguas() {
		return LesionesAntiguas;
	}
	public void setLesionesAntiguas(String lesionesAntiguas) {
		LesionesAntiguas = lesionesAntiguas;
	}
	
	@Override
	public String toString() {
		return "AntecedentesPersonales [EnfermedadesGraves=" + EnfermedadesGraves + ", OperacionesQuirurjicas="
				+ OperacionesQuirurjicas + ", TratamientoMedicoActual=" + TratamientoMedicoActual
				+ ", LesionesAntiguas=" + LesionesAntiguas + "]";
	}
	public int getOid_cliente() {
		return oid_cliente;
	}
	public void setOid_cliente(int oid_cliente) {
		this.oid_cliente = oid_cliente;
	}

}
