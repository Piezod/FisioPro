package error;

public class GenericException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String descripcion;
	
	public GenericException(String desc) {
		this.descripcion=desc;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}
