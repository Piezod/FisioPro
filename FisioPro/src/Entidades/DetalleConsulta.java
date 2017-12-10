package Entidades;

public class DetalleConsulta {
	
	
	
	private String oid_consulta;
	private Cliente detallecliente;
	private Anamnesis detalleanamnesis;
	private Exploracion detalleexploraci�n;
	private Tratamiento detalletratamiento;
	private String fecha;
	private String motivo;
	
	public DetalleConsulta() {
		/*
		 * Instanciamos todos los objetos para que se puedan rellenar
		 */
		detallecliente=new Cliente();
		detalleanamnesis=new Anamnesis();
		detalleexploraci�n=new Exploracion();
		detalletratamiento=new Tratamiento();
		
	}
	
	public String getOid_consulta() {
		return oid_consulta;
	}
	public void setOid_consulta(String oid_consulta) {
		this.oid_consulta = oid_consulta;
	}
	public Cliente getDetallecliente() {
		return detallecliente;
	}
	public void setDetallecliente(Cliente detallecliente) {
		this.detallecliente = detallecliente;
	}
	public Anamnesis getDetalleanamnesis() {
		return detalleanamnesis;
	}
	public void setDetalleanamnesis(Anamnesis detalleanamnesis) {
		this.detalleanamnesis = detalleanamnesis;
	}
	public Exploracion getDetalleexploraci�n() {
		return detalleexploraci�n;
	}
	public void setDetalleexploraci�n(Exploracion detalleexploraci�n) {
		this.detalleexploraci�n = detalleexploraci�n;
	}
	public Tratamiento getDetalletratamiento() {
		return detalletratamiento;
	}
	public void setDetalletratamiento(Tratamiento detalletratamiento) {
		this.detalletratamiento = detalletratamiento;
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
		return "DetalleConsulta [oid_consulta=" + oid_consulta + ", detallecliente=" + detallecliente
				+ ", detalleanamnesis=" + detalleanamnesis + ", detalleexploraci�n=" + detalleexploraci�n
				+ ", detalletratamiento=" + detalletratamiento + ", fecha=" + fecha + ", motivo=" + motivo + "]";
	}

}
