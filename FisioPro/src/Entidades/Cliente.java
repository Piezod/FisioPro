package Entidades;

public class Cliente {
	
	private String nombre;
	private String Apellido1;
	private String Apellido2;
	private int Edad;
	private int Telefono;

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido1() {
		return Apellido1;
	}
	public void setApellido1(String apellido1) {
		Apellido1 = apellido1;
	}
	public String getApellido2() {
		return Apellido2;
	}
	public void setApellido2(String apellido2) {
		Apellido2 = apellido2;
	}
	public int getEdad() {
		return Edad;
	}
	public void setEdad(String edad) {
		Edad =  Integer.parseInt(edad);
	}
	public int getTelefono() {
		return Telefono;
	}
	public void setTelefono(String telefono) {
		Telefono = Integer.parseInt(telefono);
	}
	
	@Override
	public String toString() {
		return "Cliente [nombre=" + nombre + ", Apellido1=" + Apellido1 + ", Apellido2=" + Apellido2 + ", Edad=" + Edad
				+ ", Telefono=" + Telefono + "]";
	}
 
	
}
