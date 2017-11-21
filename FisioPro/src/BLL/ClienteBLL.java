package BLL;


import java.sql.SQLException;

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
		cli.setNombre(nombre);
		cli.setApellido1(ape1);
		cli.setApellido2(ape2);
		cli.setEdad(edad);
		cli.setTelefono(telefono);
	}
	
	/**
	 * 
	 * Metodo que nos realizara el alta, validaciones, llamada a dal y nos devuelve el id
	 * del cliente dado de alta.
	 * @return devuelve el id del cliente dado de alta, en caso de error devuelve un 0
	 */
	public int altacliente()
	{
		
		int exito=0;;
		try {
				ClienteDAL cdal=new ClienteDAL(cli);
				if (cdal.AltaCliente()>0)
				{					
					exito=cdal.obtenerultimoid();	
				}
		} catch (Exception e) {
			// TODO: handle exception
			exito=0;
			System.err.println("Error en cliente.bll alta cliente" + e);
		}
		
		return exito;
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
