package Entidades;

public class Cliente {
	
	private String nombre = "Vacio";
	private String Apellido1 = "Vacio";
	private String Apellido2 = "Vacio";
	private int Edad = 99;
	private int Telefono = 666666666;
	private int oid_cliente;

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
				+ ", Telefono=" + Telefono + ", oid_cliente =" + oid_cliente + "]";
	}
	
	public int getOid() {
		return oid_cliente;
	}
	public void setOid(int oid_cliente) {
		this.oid_cliente = oid_cliente;
	}
 
	
}
