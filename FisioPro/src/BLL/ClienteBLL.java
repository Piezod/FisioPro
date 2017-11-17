package BLL;
import javax.swing.plaf.synth.SynthScrollBarUI;

import BD.*;
import Entidades.*;
public class ClienteBLL {
	
	private Cliente cli;
	
	
	public ClienteBLL() {
		// TODO Auto-generated constructor stub
	}
	
	public ClienteBLL(String nombre,String ape1,String ape2,String edad,String telefono) throws Exception {
		// TODO Auto-generated method stub

		cli=new Cliente();
		if (validardatoscliente(nombre, ape1, ape2, edad, telefono))
		{
		cli.setNombre(nombre);
		cli.setApellido1(ape1);
		cli.setApellido2(ape2);
		cli.setEdad(edad);
		cli.setTelefono(telefono);
		}
		else
		{
			throw new Exception ("error campos no validos para el cliente"					) {
				
					};
		}
	}
	
	/**
	 * 
	 * Metodo que nos realizara el alta, validaciones, llamada a dal.
	 * @return si se ha producido el alta o no
	 */
	public boolean altacliente()
	{
		
		boolean fin=true;
		try {
			
				ClienteDAL cdal=new ClienteDAL(cli);
				if (cdal.AltaCliente()==0)
					fin=false;
		} catch (Exception e) {
			// TODO: handle exception
			fin=false;
			System.err.println("Error en cliente.bll alta cliente");
		}
		
		return fin;
	}

	/**
	 * Metodo que me valida los datos recogidos del cliente, devolvera 
	 * true cuando este todo correcto o false cuando algún dato falle
	 * @return val = ture o false dependiendo si esta todo correcto o no
	 */
	public boolean validardatoscliente(String nombre,String ape1,String ape2,String edad,String telefono)
	{
		boolean val=true;
		
		if (Utilidades.EsVacia(nombre)
			|| Utilidades.EsVacia(ape1)
					|| Utilidades.EsVacia(ape2))
		{
			val=false;
		}else if (!Utilidades.EsValidoTlfno(""+telefono))
		{
			val=false;
		}else if (!Utilidades.EsPositivo(Integer.parseInt(edad)))
		{
			val=false;
		}
		
		return val;
	}
}
